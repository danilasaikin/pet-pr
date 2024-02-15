import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountByIdAndPin(String accountId, String pin) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountId) && account.checkPin(pin)) {
                return account;
            }
        }
        return null;
    }

    public boolean makeTransfer(Account sourceAccount, String targetAccountNumber, double amount) {
        Account targetAccount = getAccountByNumber(targetAccountNumber);
        if (targetAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.withdraw(amount);
            targetAccount.deposit(amount);
            Transaction transaction = new Transaction(sourceAccount.getAccountNumber(), targetAccountNumber, amount);
            sourceAccount.addTransaction(transaction);
            targetAccount.addTransaction(transaction);
            return true;
        }
        return false;
    }

    private Account getAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
