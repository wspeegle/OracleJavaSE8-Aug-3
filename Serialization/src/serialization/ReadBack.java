package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadBack {

    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream("data.dat"))) {
            Object o = ois.readObject();
            System.out.println("Read a: " + o.getClass().getName()
                + " with toString: " + o);
        } catch (IOException ex) {
            Logger.getLogger(ReadBack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadBack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
