package localization;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Localization {

    public static void main(String[] args) throws Throwable {
        Locale.setDefault(Locale.CANADA_FRENCH);
        Properties prop = System.getProperties();
        prop.forEach((k,v)->System.out.println(k + " : " + v));
        System.out.println("==================");
        System.out.println("property simon has value " 
            + prop.getProperty("simon"));
        System.out.println("==================");
        System.out.println("simon.number is " 
            + Integer.getInteger("simon.number"));
        System.out.println("==================");
        Properties personal = new Properties();
        personal.load(new FileReader("MyProperties.properties"));
        personal.list(System.out);

        ResourceBundle rb =  ResourceBundle.getBundle("res.MyResources");
        System.out.println("resName is " + rb.getString("resName"));
        System.out.println("resValue is " + rb.getString("resValue"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("Today is " + dtf.format(ldt));
    }
    
}
