package innercomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InnerComparator {

    public static void showSortedList(List<Student> ls, Comparator<Student> cs) {
        ls.sort(cs);
        System.out.println("============");
        System.out.println("list: " + ls);
    }

    public static void main(String[] args) {
        List<Student> ls = new ArrayList<Student>();
        ls.add(new Student("Fred", 3.2F));
        ls.add(new Student("Sheila", 3.9F));
        ls.add(new Student("Jim", 2.9F));

        System.out.println("list: " + ls);
        showSortedList(ls, Student.getGPAComparator());
        
        showSortedList(ls, new Student.NameComparator());
        
        showSortedList(ls, (s1, s2)-> s1.getName().compareTo(s2.getName()));
    }
}
