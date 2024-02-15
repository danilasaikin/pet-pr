import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String transactionId = this.generateTransactionId();
    private Date date = new Date();
    private String sourceAccountNumber;
    private String targetAccountNumber;
    private double amount;

    public Transaction(String sourceAccountNumber, String targetAccountNumber, double amount) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.targetAccountNumber = targetAccountNumber;
        this.amount = amount;
    }

    private String generateTransactionId() {
        return UUID.randomUUID().toString();
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public Date getDate() {
        return this.date;
    }

    public String getSourceAccountNumber() {
        return this.sourceAccountNumber;
    }

    public String getTargetAccountNumber() {
        return this.targetAccountNumber;
    }

    public double getAmount() {
        return this.amount;
    }
}
