package accounts;

public class Account {

    private String owner;
    private int balance;
    private String homeBank = "Main branch";

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if (owner != null) {
            this.owner = owner;
        }
    }

    public int getBalance() {
        return balance;
    }
    
    protected String getHomeBank() {
        return homeBank;
    }
    
    public int withdraw(int request) {
        balance -= request;
        return request;
    }
    
    public void deposit(int deposit) {
        balance += deposit;
    }

    public Account(String owner, int balance) {
        if (owner == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        this.owner = owner;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "holder=" + owner
            + ", balance=" + balance + '}';
    }

}
