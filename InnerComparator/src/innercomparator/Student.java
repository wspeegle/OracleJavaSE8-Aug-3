package innercomparator;

import java.util.Comparator;

public class Student {

    public float getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }

    private float gpa;
    private String name;

    public Student(String name, float gpa) {
        this.gpa = gpa;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + '}';
    }
    
    public static Comparator<Student> getGPAComparator() {
        
        return (o1, o2) -> (o1.gpa > o2.gpa)  ? 1 
                    : (o2.gpa > o1.gpa)  ? -1 : 0;
    }

//
//    public static Comparator<Student> getGPAComparator() {
//        
//        return /*new Comparator<Student>() {
//            @Override
//            public int compare*/(Student o1, Student o2) -> {
//                if (o1.gpa > o2.gpa) {
//                    return 1;
//                }
//                if (o2.gpa > o1.gpa) {
//                    return -1;
//                }
//                return 0;
//            }
//        /*}*/;
//    }

//    public static Comparator<Student> getGPAComparator() {
//        return new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                if (o1.gpa > o2.gpa) {
//                    return 1;
//                }
//                if (o2.gpa > o1.gpa) {
//                    return -1;
//                }
//                return 0;
//            }
//        };
//    }
//   private static final Comparator<Student> gpaComparator =
//        new /*GPAComparator();
//    
//    private static class GPAComparator implements*/ Comparator<Student>() {
//        @Override
//        public int compare(Student o1, Student o2) {
//            if (o1.gpa > o2.gpa) {
//                return 1;
//            }
//            if (o2.gpa > o1.gpa) {
//                return -1;
//            }
//            return 0;
//        }
//    };
//
//    private static final Comparator<Student> gpaComparator =
//        new GPAComparator();
//    
//    private static class GPAComparator implements Comparator<Student> {
//        @Override
//        public int compare(Student o1, Student o2) {
//            if (o1.gpa > o2.gpa) {
//                return 1;
//            }
//            if (o2.gpa > o1.gpa) {
//                return -1;
//            }
//            return 0;
//        }
//    }
    public static class NameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}
