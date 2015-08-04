package accounts;

import java.util.Objects;

public class Account /* extends Object */ {

    private static final Account[] accounts = {
        new Account("Fred", 10_000),
        new CheckingAccount("Sheila", 1_000, 5_000),
        new Account("Jim", 0)
    };

    public static Account findByFirstName(String firstName) {
        Account rv = null;
aLoop:  for (Account a : accounts) {
            if (a.owner.equals(firstName)) {
                rv = a;
                break aLoop; // loop label redundant for single loop!
            }
        }
        return rv;
    }

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

    @Override
    public boolean equals(Object other) {
        if (other.getClass() == Account.class) {
            Account o = (Account) other;
            if (this.owner.equals(o.owner)
                && this.homeBank.equals(o.homeBank)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.owner);
        hash = 37 * hash + Objects.hashCode(this.homeBank);
        return hash;
    }

}
