package serialization;

import java.io.Serializable;

public class Other implements Serializable {
    private String name;

    public Other(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Other{" + "name=" + name + '}';
    }
    
}
