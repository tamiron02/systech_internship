package java_systechtraining.Exercises;

public class java_se_07 {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public java_se_07(String acNumber, String acHolderName) {
        this.accountNumber = acNumber;
        this.accountHolderName = acHolderName;
        this.balance = 0.0; // Initialize balance to 0
    }
    public java_se_07(String acNumber, String acHolderName, double initialBalance) {
        this.accountNumber = acNumber;
        this.accountHolderName = acHolderName;
        this.balance = initialBalance; // Initialize with given balance
    }
    public java_se_07(){
        accountNumber = "000000";
        accountHolderName = "Default Name";
        balance = 0.0;
        
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("deposited:" + amount);
        }else{
                System.out.println("Deposit amount must be positive");
    
            }
        }
    
        public void withdraw(double amount){
            if(amount > 0 && amount <= balance){
                balance -= amount;
                System.out.println("withdrawn:" + amount);
            }else{
                System.out.println("Invalid withdraw amount");
            }
        }

        public double getBalance(){
            return balance;
        }

    public static void main(String[] args) {
        java_se_07 account1 = new java_se_07("123456", "John Doe", 500.0);
        account1.deposit(200.0);
        account1.withdraw(100.0);

    }
}

