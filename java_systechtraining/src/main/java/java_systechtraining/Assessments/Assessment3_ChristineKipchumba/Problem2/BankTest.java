package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem2;

public class BankTest {
    
    public static void main(String[] args) {
      
            BankAccount account1 = new BankAccount("ACC001", "Alice", 1000);
            BankAccount account2 = new BankAccount("ACC002", "Bob", 500);

            try {
                account1.deposit(-100); // Should throw InvalidTransactionException
            } catch (InvalidTransactionException e) {
                System.out.println("Transaction error: " + e.getMessage());
            }

            try {
                account1.withdraw(2000); // Should throw InsufficientFundsException
            } catch (InsufficientFundsException e) {
                System.out.println("Funds error: " + e.getMessage());
            }

            try {
                account1.transfer("INVALID", 100); // Should throw AccountNotFoundException or InsufficientFundsException
            } catch (AccountNotFoundException e) {
                System.out.println("Account error: " + e.getMessage());
            } catch (InsufficientFundsException e) {
                System.out.println("Funds error: " + e.getMessage());
            } finally {
                System.out.println("Transaction processing completed");
            }
        }
    }


