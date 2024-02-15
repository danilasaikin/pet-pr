public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");
        Owner owner1 = new Owner("John Doe", "123456789");
        Owner owner2 = new Owner("Jane Smith", "987654321");
        Account account1 = new Account("1001", "1234", owner1);
        Account account2 = new Account("1002", "5678", owner2);
        bank.addAccount(account1);
        bank.addAccount(account2);
        ATM atm = new ATM(bank, "ATM-001");
        atm.start();
    }
}
