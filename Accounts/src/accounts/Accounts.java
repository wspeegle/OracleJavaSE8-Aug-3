package accounts;

public class Accounts {

    public static void showAccount(Account a) {
        System.out.println("Accout info: " + a);
    }

    public static void main(String[] args) {
        Account[] accounts = {
            new Account("Fred", 10_000),
            new CheckingAccount("Sheila", 1_000, 5_000),
            new Account("Jim", 0)
        };

        System.out.println("Home bank for Fred is "
            + accounts[0].getHomeBank());
        accounts[0].setOwner("Fred");
        showAccount(accounts[0]);
        accounts[1].setOwner(null);
        showAccount(accounts[1]);

        System.out.println("==========================");
        accounts[0].deposit(10_000);
        for (Account a : accounts) {
            showAccount(a);
            if (a.withdraw(15_000) != 15_000) {
                System.out.println("Withdraw denied!");
                if (a instanceof CheckingAccount) {
                    System.out.println("Have a checking account"
                        + ", seeking overdraft");
                    CheckingAccount ca
                        = (CheckingAccount) a;
                    ca.setOverdraftLimit(-20_000);
                    if (a.withdraw(15_000) == 15_000) {
                        System.out.println("Withdraw succeeded!");
                    }
                }
            }
        }

        System.out.println("==========================");
        for (Account a : accounts) {
            showAccount(a);
        }
    }
}
