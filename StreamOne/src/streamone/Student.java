package streamone;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {

    private float gpa;
    private String name;
    private List<String> courses;
    
    public float getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }

    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }
    
    public Student(String name, float gpa, String ... courses) {
        this.gpa = gpa;
        this.name = name;
        this.courses = Arrays.asList(courses);
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + '}';
    }
    
    public static Comparator<Student> getGPAComparator() {
        
        return (o1, o2) -> (o1.gpa > o2.gpa)  ? 1 
                    : (o2.gpa > o1.gpa)  ? -1 : 0;
    }

    public static class NameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}
