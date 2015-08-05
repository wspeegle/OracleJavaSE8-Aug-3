package mapexample;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        // Non-generic List...
        List l = new ArrayList();
        l.add("Fred");
        l.add("Jim");
//        l.add(new Date()); // generics help prevent this!!!!
        for (int i = 0; i < l.size(); i++) {
            String str = (String)(l.get(i));
            System.out.println("got " + str);
        }
        
        Map<String, Student> roster = new HashMap<>();
        roster.put("Fred", new Student("Fred", 3.2F));
        roster.put("Jim", new Student("Jim", 2.8F));
        roster.put("Simon", new Student("Simon", 1.7F));
        roster.put("Shiela", new Student("Sheila", 3.9F));
        roster.put("Jane", new Student("Jane", 3.3F));
        
        Student s = roster.get("Jane");
        System.out.println("Jane found: " + s);
        roster.put("Simon", new Student("Simon's been studying", 2.7F));
        s = roster.get("Simon");
        System.out.println("Simon found: " + s);
        s = roster.get("Orinoco");
        System.out.println("Orinoco found: " + s);
//        assert s != null : 
//            "s should not be null, roster.get(\"Jane\" is " + roster.get("Jane");
//        System.out.println("s has gpa of " + s.getGpa());
        
        for (Map.Entry<String, Student> ent : roster.entrySet()) {
            System.out.println("> key: " + ent.getKey()
                + " value: " + ent.getValue());
        }
    }
    
}
