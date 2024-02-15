//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String pin;
    private Owner owner;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, String pin, Owner owner) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.owner = owner;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        Transaction transaction = new Transaction(this.accountNumber, this.accountNumber, amount);
        this.transactionHistory.add(transaction);
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            Transaction transaction = new Transaction(this.accountNumber, this.accountNumber, -amount);
            this.transactionHistory.add(transaction);
        } else {
            System.out.println("Недостаточно средств на счете.");
        }

    }

    public boolean checkPin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public void addTransaction(Transaction transaction) {
        this.transactionHistory.add(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return this.transactionHistory;
    }
}
