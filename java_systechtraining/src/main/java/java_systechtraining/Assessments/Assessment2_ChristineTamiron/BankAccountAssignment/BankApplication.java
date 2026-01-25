package java_systechtraining.Assessments.Assessment2_ChristineTamiron.BankAccountAssignment;    

import java.util.Scanner;

// ==================== MAIN APPLICATION CLASS ====================

public class BankApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        System.out.println("Welcome to the Secure Bank Account System!");
        System.out.println("Features: Password Protection & Automatic Interest Scheduling");

        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        createSavingsAccount();
                        break;
                    case 2:
                        createCheckingAccount();
                        break;
                    case 3:
                        depositMoney();
                        break;
                    case 4:
                        withdrawMoney();
                        break;
                    case 5:
                        checkBalance();
                        break;
                    case 6:
                        applyInterest();
                        break;
                    case 7:
                        applyScheduledInterest();
                        break;
                    case 8:
                        changePassword();
                        break;
                    case 9:
                        bank.displayAllAccounts();
                        break;
                    case 10:
                        displayTotalBalance();
                        break;
                    case 11:
                        System.out.println("Thank you for using the Bank Account System!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Bank Account System ===");
        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Checking Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Check Balance");
        System.out.println("6. Apply Interest (Savings)");
        System.out.println("7. Apply Scheduled Interest (Auto)");
        System.out.println("8. Change Password");
        System.out.println("9. Display All Accounts");
        System.out.println("10. Display Total Balance");
        System.out.println("11. Exit");
        System.out.println("===========================");
    }

    private static void createSavingsAccount() throws InvalidAmountException {
        System.out.println("\n--- Create Savings Account ---");
        String accountNumber = getStringInput("Enter account number: ");
        String accountHolder = getStringInput("Enter account holder name: ");
        double initialBalance = getDoubleInput("Enter initial balance: ");
        double interestRate = getDoubleInput("Enter annual interest rate (e.g., 0.03 for 3%): ");
        String password = getStringInput("Create password (min 4 characters): ");

        SavingsAccount account = new SavingsAccount(accountNumber, accountHolder,
                initialBalance, interestRate, password);
        bank.addAccount(account);
    }

    private static void createCheckingAccount() throws InvalidAmountException {
        System.out.println("\n--- Create Checking Account ---");
        String accountNumber = getStringInput("Enter account number: ");
        String accountHolder = getStringInput("Enter account holder name: ");
        double initialBalance = getDoubleInput("Enter initial balance: ");
        double overdraftLimit = getDoubleInput("Enter overdraft limit: ");
        String password = getStringInput("Create password (min 4 characters): ");

        CheckingAccount account = new CheckingAccount(accountNumber, accountHolder,
                initialBalance, overdraftLimit, password);
        bank.addAccount(account);
    }

    private static void depositMoney() throws InvalidAmountException, AuthenticationException {
        String accountNumber = getStringInput("Enter account number: ");
        String password = getStringInput("Enter password: ");
        
        BankAccount account = bank.authenticateAccount(accountNumber, password);

        double amount = getDoubleInput("Enter deposit amount: ");
        account.deposit(amount);
        System.out.printf("Deposited $%.2f successfully. New balance: $%.2f%n",
                amount, account.getBalance());
    }

    private static void withdrawMoney() throws InsufficientFundsException, 
            InvalidAmountException, AuthenticationException {
        String accountNumber = getStringInput("Enter account number: ");
        String password = getStringInput("Enter password: ");
        
        BankAccount account = bank.authenticateAccount(accountNumber, password);

        double amount = getDoubleInput("Enter withdrawal amount: ");
        account.withdraw(amount);
        System.out.printf("Withdrew $%.2f successfully. New balance: $%.2f%n",
                amount, account.getBalance());
    }

    private static void checkBalance() throws AuthenticationException {
        String accountNumber = getStringInput("Enter account number: ");
        String password = getStringInput("Enter password: ");
        
        BankAccount account = bank.authenticateAccount(accountNumber, password);

        System.out.printf("Current balance: $%.2f%n", account.getBalance());
        
        if (account instanceof SavingsAccount) {
            long monthsPassed = account.getMonthsSinceLastInterest();
            System.out.printf("Months since last interest: %d%n", monthsPassed);
        }
    }

    private static void applyInterest() throws AuthenticationException {
        String accountNumber = getStringInput("Enter account number: ");
        String password = getStringInput("Enter password: ");
        
        BankAccount account = bank.authenticateAccount(accountNumber, password);

        if (account instanceof SavingsAccount) {
            ((SavingsAccount) account).applyInterest();
        } else {
            System.out.println("Interest can only be applied to savings accounts.");
        }
    }

    private static void applyScheduledInterest() {
        System.out.println("\nApplying scheduled interest to all savings accounts...");
        bank.applyScheduledInterestToAll();
    }

    private static void changePassword() throws AuthenticationException {
        String accountNumber = getStringInput("Enter account number: ");
        String oldPassword = getStringInput("Enter current password: ");
        
        BankAccount account = bank.authenticateAccount(accountNumber, oldPassword);
        
        String newPassword = getStringInput("Enter new password (min 4 characters): ");
        String confirmPassword = getStringInput("Confirm new password: ");
        
        if (!newPassword.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            return;
        }
        
        account.changePassword(oldPassword, newPassword);
    }

    private static void displayTotalBalance() {
        double total = bank.calculateTotalBalance();
        System.out.printf("Total balance across all accounts: $%.2f%n", total);
    }

    // Helper methods for input
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}