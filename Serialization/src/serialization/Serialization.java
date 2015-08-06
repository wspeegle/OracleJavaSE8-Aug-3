package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serialization {

    public static void main(String[] args) {
        DataThingy t1 = new DataThingy("Fred", 99, 
            new Other("Albert"), new Other("Bert"));
        try (ObjectOutputStream oos = 
                new ObjectOutputStream(new FileOutputStream("data.dat"))){
            oos.writeObject(t1);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
