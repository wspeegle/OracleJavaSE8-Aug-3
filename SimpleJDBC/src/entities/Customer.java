package entities;

public class Customer {
    private int pk;
    private String name;
    private String zip;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Customer(int pk, String name, String zip) {
        this.pk = pk;
        this.name = name;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Customer{" + "pk=" + pk + ", name=" + name + ", zip=" + zip + '}';
    }
    
}
