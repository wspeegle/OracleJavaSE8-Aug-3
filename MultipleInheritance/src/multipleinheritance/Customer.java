package multipleinheritance;

public class Customer implements Addressable {
    private String street;
    private String city;
    private String zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Customer(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
    
}
