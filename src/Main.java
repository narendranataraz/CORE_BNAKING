import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Thread implements Runnable {

   // private static final int CLIENT_COUNT = 5;
    private static final int CLIENT_COUNT = 10;
    private static final int CLIENT_ITERATIONS = 5;
    private static final int ACCOUNTS_COUNT = 2;

    private static final int RAND_MIN = 10;
    private static final int RAND_MAX = 10;
    private static final int RAND_MIN_AMOUNT = 10;
    private static final int RAND_MAX_AMOUNT = 200;

    private static Bank bank = new Bank(ACCOUNTS_COUNT);
    private Client client;

    public Main(Client c) {
    	  client = c;
    }

    private int randAmount() {
        return (new Random()).nextInt((RAND_MAX_AMOUNT - RAND_MIN_AMOUNT) + 1)
                + RAND_MIN_AMOUNT;
    }

    private int randSleepTime() {
        return (new Random()).nextInt((RAND_MAX - RAND_MIN) + 1) + RAND_MIN;
    }

    public static void main(String[] args) {
        for (int i = 0; i < CLIENT_COUNT; i++) {
            Main ts1 = new Main(new Client("Person " + i));
            ts1.start();
        }
    }

    private void clientWork() {
        try {
            Thread.sleep(randSleepTime());
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < CLIENT_ITERATIONS; i++) {
            Account acc = bank.getRandomAccount();
            clientWork();
            acc.withdraw(client, randAmount());
            clientWork();
            acc.deposit(client, randAmount());
        }
        System.out.println("#Account balance: " + Account.getBalance());
    }
}