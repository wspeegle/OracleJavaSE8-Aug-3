
package streamone;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class StreamOne {

    public static void main(String[] args) {
        List<Student> ls = new ArrayList<Student>();
        ls.add(new Student("Fred", 3.2F, "Physics", "Math", "Chemistry"));
        ls.add(new Student("Sheila", 3.9F, "PoliSci", "Classics"));
        ls.add(new Student("Jim", 2.9F, "History", "Classics"));
        ls.add(new Student("Alice", 3.2F, "Physics", "Math", "Chemistry"));
        ls.add(new Student("Bob", 3.9F, "PoliSci", "Classics"));
        ls.add(new Student("Silent Bob", 3.9F, "PoliSci", "Classics"));
        ls.add(new Student("Maverick", 2.9F, "History", "Classics"));
        
        ls.stream()
            .flatMap(s->s.getCourses().stream())
            .distinct()
            .sorted()
            .forEach(System.out::println);
        
        System.out.println("=============");
        ls
            .stream()
//            .filter(s->s.getGpa()>3.0F)
            .sorted((s1,s2)->new Float(s2.getGpa()).compareTo(s1.getGpa()))
            .forEach(System.out::println)
            ;
        
        System.out.println("==================");
        Optional<String> opt = ls
            .stream()
            .map(s-> s.getName() + " has a gpa of " + s.getGpa())
            .peek(s->System.out.println("Peek sees: " + s))
            .filter(s->s.length() > 2)
            .findFirst()
//            .forEach(System.out::println)
            ;
        
        System.out.println(">> " + opt.orElse("NOTHING FOUND"));
        System.out.println("==================");

        DoubleSummaryStatistics dss = ls
            .stream()
            .mapToDouble(Student::getGpa)
            .summaryStatistics()
            ;
        
        System.out.println("Summary: " + dss);
        System.out.println("==================");
       
        Supplier<double[]> doubleArraySupplier = () -> new double[1];
        ObjDoubleConsumer<double[]> objDoubleCons = (b,i)->b[0]+=i;
        BiConsumer<double[],double[]> biConsDouble = (b, b1)->b[0]+=b1[0];
        
        System.out.println("Sum of GPAs is "
            + ls.stream()
            .mapToDouble(Student::getGpa)
            .collect(
                () -> new double[1],
                (b,i)->b[0]+=i,
                (b, b1)->b[0]+=b1[0])[0]);
//            .reduce((s,t)->s+t).get());
        System.out.println("==================");
        Map<Float, Long> m = ls.stream()
            .collect(Collectors.groupingBy(s->s.getGpa(),
                Collectors.counting()));
        m.forEach((k,v)->System.out.println(k + " achieved by " + v));
    }
    
}
