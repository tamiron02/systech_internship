package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem2;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    private static Map<String, BankAccount> accounts = new HashMap<>();

    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        accounts.put(accountNumber, this);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidTransactionException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
    }

    public void transfer(String toAccountNumber, double amount)
            throws InsufficientFundsException, AccountNotFoundException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Transfer amount must be positive.");
        }
        BankAccount toAccount = accounts.get(toAccountNumber);
        if (toAccount == null) {
            throw new AccountNotFoundException("Account " + toAccountNumber + " not found.");
        }
        this.withdraw(amount);
        toAccount.deposit(amount);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }
}