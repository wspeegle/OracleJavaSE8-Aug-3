package genericexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class GenericMethod {

    public static <E> List<E> filter(List<E> ls, Predicate<E> ps) {
        List<E> output = new ArrayList<>();
        for (E s : ls) {
            if (ps.test(s)) {
                output.add(s);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        List<Student> ls = new ArrayList<Student>();
        ls.add(new Student("Fred", 3.2F));
        ls.add(new Student("Sheila", 3.9F));
        ls.add(new Student("Jim", 2.9F));

        System.out.println("smart students " + filter(ls, s->s.getGpa()>3.0F));
        System.out.println("less-smart students " + filter(ls, s->s.getGpa()<3.0F));

        List<String> lstr = Arrays.asList("Banana", "Apricot", "Apple", "Strawberry");
        System.out.println("Strings beginning with A " 
            + filter(lstr, s -> s.startsWith("A")));
    }
}
