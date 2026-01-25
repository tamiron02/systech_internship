/**
 * Basic Bank Account System with Bonus Features
 * Features Implemented:
 * - Complete encapsulation with validation
 * - Inheritance hierarchy (Savings/Checking accounts)
 * - Polymorphic account management
 * - Custom exception handling
 * - Menu-driven interface
 * 
 * BONUS FEATURES:
 * - Password Protection: Account authentication system
 * - Interest Scheduling: Automatic monthly interest application
 */
package java_systechtraining.Assessments.Assessment2_ChristineTamiron.BankAccountAssignment;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// ==================== CUSTOM EXCEPTIONS ====================

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}

// ==================== BASE BANK ACCOUNT CLASS ====================

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    protected double balance;
    private String password; // Password protection
    private LocalDate lastInterestDate; // For interest scheduling

    public BankAccount(String accountNumber, String accountHolder, double initialBalance, String password)
            throws InvalidAmountException {
        setAccountNumber(accountNumber);
        setAccountHolder(accountHolder);
        setPassword(password);
        if (initialBalance < 0) {
            throw new InvalidAmountException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
        this.lastInterestDate = LocalDate.now();
    }

    // Getters and Setters with validation
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Password methods
    private void setPassword(String password) {
        if (password == null || password.length() < 4) {
            throw new IllegalArgumentException("Password must be at least 4 characters");
        }
        this.password = password;
    }

    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void changePassword(String oldPassword, String newPassword) throws AuthenticationException {
        if (!authenticate(oldPassword)) {
            throw new AuthenticationException("Incorrect current password");
        }
        setPassword(newPassword);
        System.out.println("Password changed successfully!");
    }

    // Interest scheduling methods
    public LocalDate getLastInterestDate() {
        return lastInterestDate;
    }

    protected void setLastInterestDate(LocalDate date) {
        this.lastInterestDate = date;
    }

    public long getMonthsSinceLastInterest() {
        return ChronoUnit.MONTHS.between(lastInterestDate, LocalDate.now());
    }

    // Account operations
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account[Number: %s, Holder: %s, Balance: $%.2f]",
                accountNumber, accountHolder, balance);
    }
}

// ==================== SAVINGS ACCOUNT CLASS ====================

class SavingsAccount extends BankAccount {
    private double interestRate;
    private static final double MIN_BALANCE = 100.0;

    public SavingsAccount(String accountNumber, String accountHolder,
                          double initialBalance, double interestRate, String password)
            throws InvalidAmountException {
        super(accountNumber, accountHolder, initialBalance, password);
        setInterestRate(interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0 || interestRate > 1) {
            throw new IllegalArgumentException("Interest rate must be between 0 and 1");
        }
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (balance - amount < MIN_BALANCE) {
            throw new InsufficientFundsException(
                    "Cannot withdraw: Minimum balance of $" + MIN_BALANCE + " required");
        }
        balance -= amount;
    }

    // Manual interest application
    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        setLastInterestDate(LocalDate.now());
        System.out.printf("Interest applied: $%.2f. New balance: $%.2f%n", interest, balance);
    }

    // Automatic monthly interest application
    public void applyScheduledInterest() {
        long monthsPassed = getMonthsSinceLastInterest();
        
        if (monthsPassed > 0) {
            // Apply monthly compound interest for each month
            for (int i = 0; i < monthsPassed; i++) {
                double monthlyRate = interestRate / 12; // Assume annual rate
                balance += balance * monthlyRate;
            }
            setLastInterestDate(LocalDate.now());
            System.out.printf("Scheduled interest applied for %d month(s). New balance: $%.2f%n", 
                    monthsPassed, balance);
        } else {
            System.out.println("No scheduled interest due yet.");
        }
    }

    @Override
    public String toString() {
        return String.format("SavingsAccount[Number: %s, Holder: %s, Balance: $%.2f, Interest Rate: %.2f%%, Last Interest: %s]",
                getAccountNumber(), getAccountHolder(), balance, interestRate * 100, getLastInterestDate());
    }
}

// ==================== CHECKING ACCOUNT CLASS ====================

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder,
                           double initialBalance, double overdraftLimit, String password)
            throws InvalidAmountException {
        super(accountNumber, accountHolder, initialBalance, password);
        setOverdraftLimit(overdraftLimit);
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
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (amount > balance + overdraftLimit) {
            throw new InsufficientFundsException(
                    "Cannot withdraw: Exceeds overdraft limit of $" + overdraftLimit);
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("CheckingAccount[Number: %s, Holder: %s, Balance: $%.2f, Overdraft Limit: $%.2f]",
                getAccountNumber(), getAccountHolder(), balance, overdraftLimit);
    }
}

// ==================== BANK MANAGEMENT CLASS ====================

class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        // Check for duplicate account numbers
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(account.getAccountNumber())) {
                System.out.println("Error: Account number already exists!");
                return;
            }
        }
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public BankAccount authenticateAccount(String accountNumber, String password) 
            throws AuthenticationException {
        BankAccount account = findAccount(accountNumber);
        
        if (account == null) {
            throw new AuthenticationException("Account not found");
        }
        
        if (!account.authenticate(password)) {
            throw new AuthenticationException("Invalid password");
        }
        
        return account;
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the system.");
            return;
        }
        System.out.println("\n=== All Bank Accounts ===");
        for (BankAccount account : accounts) {
            System.out.println(account.toString());
        }
        System.out.println("=========================\n");
    }

    public double calculateTotalBalance() {
        double total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public void applyInterestToSavingsAccounts() {
        int count = 0;
        for (BankAccount account : accounts) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).applyInterest();
                count++;
            }
        }
        System.out.println("Interest applied to " + count + " savings account(s).");
    }

    // BONUS: Automatic scheduled interest application
    public void applyScheduledInterestToAll() {
        int count = 0;
        System.out.println("\n=== Applying Scheduled Interest ===");
        for (BankAccount account : accounts) {
            if (account instanceof SavingsAccount) {
                System.out.println("\nAccount: " + account.getAccountNumber());
                ((SavingsAccount) account).applyScheduledInterest();
                count++;
            }
        }
        System.out.println("\nProcessed " + count + " savings account(s).");
        System.out.println("===================================\n");
    }
}

// ==================== MAIN APPLICATION CLASS ====================

// (BankApplication class moved to its own file BankApplication.java)