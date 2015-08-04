package bank;

import accounts.Account;

public class Manager {
    private static final Manager self;
    static {
        self = new Manager();
    }
    
    public static Manager get() {
        return self;
    }
    
    private Account[] myAccounts;
    
    
    private Manager() {}
    
    public void doStuff() {
        Account a = new Account("Orinoco", 1000);
        // inaccessible, because it's default, and 
        // we are in another package!
//        a.getHomeBank(); 
    }
}
