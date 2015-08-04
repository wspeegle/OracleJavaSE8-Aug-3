package accounts;

import bank.Manager;

public class Accounts {

    public static void showAccount(Account... a) {
        System.out.println("Info on " + a.length + " accounts:");
        for (Account acc : a) {
            System.out.println("info: " + acc);
        }
    }

    public static void main(String[] args) {
        Account[] accounts = {
            new Account("Fred", 10_000),
            new CheckingAccount("Sheila", 1_000, 5_000),
            new Account("Jim", 0)
        };

        Account testAc = new Account("Sheila", 1_000);

        // is jim "equal to" accounts[2]???
        System.out.println("testAc == accounts[1] is "
            + (testAc == accounts[1]));

        System.out.println("testAc.equals(accounts[1]) is "
            + (accounts[1].equals(testAc)));

        // Fails at runtime if the reference does not actually
        // refer to a CheckingAccount
//        CheckingAccount chk = (CheckingAccount)accounts[0];

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
        showAccount(accounts[0], accounts[1], accounts[2]);
        System.out.println("==========================");
        showAccount();
        
        Account a = Account.findByFirstName("Jim");
        System.out.println("==========================");
        showAccount(a);
        
        Manager m1 = Manager.get();
        Manager m2 = Manager.get();
        
        System.out.println("m1 ==  m2 is " + (m1 == m2));
        
    }
}
