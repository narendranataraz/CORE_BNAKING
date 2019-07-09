public class Account {
    private static int balance = 10001;
    private int number;

    public Account(int number) {
        this.number = number;
    }

    public synchronized static int getBalance() {
        return balance;
    }

    public synchronized void withdraw(Client client, int bal) {
        try {

            if (balance >= bal) {
                System.out.println(client.getName() + " "
                        + "is trying to withdraw from account " + number);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance - bal;
                System.out.println(client.getName() + " "
                        + "has completed withdrawal from account " + number);
            } else {
            	 System.out
                 .println(client.getName()
                         + " "
                         + "doesn't have enough money for withdraw  from account "
                         + number);
     }
     System.out.println(client.getName() + " withdrawal value: "
             + balance + " from account " + number);
 } catch (Exception e) {
     e.printStackTrace();
 }
    }

    public synchronized void deposit(Client client, int bal) {
        try {
            if (bal > 0) {
                System.out.println(client.getName() + " "
                        + "trying to deposit on account " + number);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance + bal;
                System.out.println(client.getName() + " "
                        + "has completed the deposit on account " + number);
            } else {
                System.out.println(client.getName() + " "
                        + " doesn't have enough money for deposit on account "
                        + number);
            }
            System.out.println(client.getName() + " deposited " + balance
                    + " on account " + number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Account " + number + " balance: " + balance;
    }
}
