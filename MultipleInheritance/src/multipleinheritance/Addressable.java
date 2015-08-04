package multipleinheritance;

import java.util.ArrayList;
import java.util.List;

public interface Addressable {
    String getStreet();
    String getCity();
    String getZip();
    default String getAddressLabel() {
        return getStreet() + '\n'
            + getCity() + '\n'
            + getZip();
    }
    
    // kinda ugly because it wwould need to refer to some concrete 
    // implementation of Addressable at some point!
    static List<Addressable> findAddressesInZipCode(String s) {
        return new ArrayList<Addressable>();
    }
}
