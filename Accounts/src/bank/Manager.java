package bank;

import accounts.Account;

public class Manager {
    public void doStuff() {
        Account a = new Account("Orinoco", 1000);
        // inaccessible, because it's default, and 
        // we are in another package!
//        a.getHomeBank(); 
    }
}
