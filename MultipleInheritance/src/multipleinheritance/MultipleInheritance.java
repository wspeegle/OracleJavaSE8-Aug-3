package multipleinheritance;

import java.util.Arrays;
import java.util.List;

public class MultipleInheritance {

    public static void main(String[] args) {
        List<Addressable> lc = Arrays.asList(
            new Customer("mystreet", "bananaville", "12345"),
            new Customer("your avenue", "stawberryton", "23456"),
            new Customer("their drive", "coconuton", "34567")
        );
        
        for(Addressable a : lc) {
            System.out.println("Address is: " );
            System.out.println(((Customer)a).getAddressLabel());
        }
    }
    
}
