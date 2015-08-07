package execservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class Callables {

    static class MyCallable implements Callable<String> {
        private static int nextId = 0;
        private String myName = "Callable " + nextId++;
        @Override
        public String call() throws Exception {
            System.out.println(myName + " started...");
            Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(3000));
            if (ThreadLocalRandom.current().nextInt(10) < 1) {
                System.out.println(myName + " completing abnormally!");
                throw new SQLException("That broke my database!");
            }
            System.out.println(myName + " completing normally");
            return myName + " completed normally";
        }
        
    }
    
    public static void main(String [] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        List<Callable<String>> jobs = Arrays.asList(
            new MyCallable(), new MyCallable(), 
            new MyCallable(), new MyCallable()
        );
        List<Future<String>> handles = new ArrayList<>();
        for (Callable<String> job : jobs) {
            handles.add(es.submit(job));
        }
        es.shutdown();
        
        while (handles.size() > 0) {
            for (int i = 0; i < handles.size(); i++) {
                Future<String> f = handles.get(i);
                if (f.isDone() || f.isCancelled()) {
                    System.out.println("A job completed!!!");
                    try {
                        String result = f.get();
                        System.out.println("Job returned: " + result);
                    } catch (InterruptedException ie) {
                        System.out.println("Job was interrupted");
                    } catch (CancellationException ce) {
                        System.out.println("Job was cancelled");
                    } catch (ExecutionException ee) {
                        System.out.println("Job threw a " + ee.getCause());
                    }
                    handles.remove(f);
                }
            }
        }
        System.out.println("All done...");
    }
}
