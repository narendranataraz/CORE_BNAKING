import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank(int accountsCount) {
        accounts = new ArrayList<Account>();
        for (int i = 0; i < accountsCount; i++) {
            accounts.add(new Account(i));
        }
    }

    public Account getRandomAccount() {
        return accounts.get((int) (Math.random() * accounts.size()));
    }

    public void printSummary() {
        for (Account a : accounts)
            System.out.println(a.toString());
    }
}