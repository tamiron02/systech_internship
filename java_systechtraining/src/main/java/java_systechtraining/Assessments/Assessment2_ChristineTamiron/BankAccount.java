//Creaed by Christine Tamiron

package java_systechtraining.Assessments.Assessment2_ChristineTamiron;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        setAccountNumber(accountNumber);
        setAccountHolder(accountHolder);
        setBalance(balance);
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder == null || accountHolder.isEmpty()) {
            throw new IllegalArgumentException("Account holder cannot be null or empty");
        }
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= amount;
    }

    
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    private static final double MIN_BALANCE = 100.0;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < MIN_BALANCE) {
            throw new IllegalArgumentException("Cannot withdraw: Minimum balance of $100 must be maintained");
        }
        super.withdraw(amount);
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
    }
}

class CheckingAccount extends BankAccount {
        @Override
        public void setBalance(double balance) {
            if (balance < -overdraftLimit) {
                throw new IllegalArgumentException("Balance cannot be less than overdraft limit");
            }
            // Directly set the balance using the parent method
            super.setBalance(Math.max(balance, 0)); // Set to 0 if positive, else use reflection for negative
            if (balance < 0) {
                try {
                    java.lang.reflect.Field balanceField = BankAccount.class.getDeclaredField("balance");
                    balanceField.setAccessible(true);
                    balanceField.set(this, balance);
                } catch (Exception e) {
                    throw new RuntimeException("Error updating balance", e);
                }
            }
        }
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative");
        }
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative");
        }
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (amount > getBalance() + overdraftLimit) {
            throw new IllegalArgumentException("Overdraft limit exceeded");
        }
        setBalance(getBalance() - amount);
    }
}

class BankDemo {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SA123", "Alice", 500, 2.5);
        BankAccount acc2 = new CheckingAccount("CA456", "Bob", 200, 150);

        System.out.println("Initial accounts:");
        System.out.println(acc1);
        System.out.println(acc2);

        acc1.deposit(100);
        acc2.deposit(50);
        System.out.println("\nAfter deposit:");
        System.out.println(acc1);
        System.out.println(acc2);

        acc1.withdraw(200); // Should work for SavingsAccount
        acc2.withdraw(400); // Should work for CheckingAccount (overdraft)
        System.out.println("\nAfter withdrawal:");
        System.out.println(acc1);
        System.out.println(acc2);

        // Apply interest to SavingsAccount
        if (acc1 instanceof SavingsAccount) {
            ((SavingsAccount) acc1).applyInterest();
            System.out.println("\nAfter applying interest to SavingsAccount:");
            System.out.println(acc1);
        }

        // Demonstrate polymorphism
        BankAccount[] accounts = {acc1, acc2};
        System.out.println("\nPolymorphic behavior:");
        for (BankAccount acc : accounts) {
            System.out.println(acc.getAccountHolder() + " balance: $" + acc.getBalance());
        }
    }
}
