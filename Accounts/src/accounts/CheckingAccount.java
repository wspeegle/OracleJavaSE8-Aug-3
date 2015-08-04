package accounts;

import accounts.Account;

public class CheckingAccount extends Account {

    private int overdraftLimit;

    public CheckingAccount(String owner,
        int balance,
        int overdraftLimit) {
        super(owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public CheckingAccount(String owner,
        int balance) {
        super(owner, balance);
        this.overdraftLimit = 0;
    }

    public int getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(int overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public int withdraw(int request) {
        if (getBalance() - request >= overdraftLimit) {
            return super.withdraw(request);
        }
        return 0;
    }
    

    @Override
    public String toString() {
        return "CheckingAccount{" + "holder=" + getOwner()
            + ", balance=" + getBalance() 
            + " overdraftLimit=" + overdraftLimit
            + " home: " + getHomeBank() + '}';
    }
}
