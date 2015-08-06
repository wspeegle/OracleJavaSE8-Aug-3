package serialization;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class DataThingy implements Serializable {
    private String name;
    private List<Other> others;
    private int x;

    public DataThingy(String name, int x, Other...others) {
        this.name = name;
        this.others = Arrays.asList(others);
        this.x = x;
    }

    @Override
    public String toString() {
        return "DataThingy{" + "name=" + name + ", others=" + others + ", x=" + x + '}';
    }
}
