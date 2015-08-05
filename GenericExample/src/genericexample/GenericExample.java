package genericexample;

import java.util.Date;

public class GenericExample {

    public static void main(String[] args) {
        Pair<String> pstr = new Pair<>("Left", "Right");
        String l = pstr.getLeft();
        
        Pair<Date> pdt = new Pair<>(new Date(), new Date());
        Date d = pdt.getLeft();
    }
    
}
