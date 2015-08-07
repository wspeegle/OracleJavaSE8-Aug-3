package execservice;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecService {

    static class MyRunnable implements Runnable {

        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " starting.   "
                + "Thread is " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000 + (int) (Math.random() * 3000));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println(name + " completing. "
                + "Thread is " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Executor ex = Executors.newFixedThreadPool(2);
        Runnable r1 = new MyRunnable("One....");
        Runnable r2 = new MyRunnable("Two....");
        Runnable r3 = new MyRunnable("Three..");
        Runnable r4 = new MyRunnable("Four...");
        ex.execute(r1);
        ex.execute(r2);
        ex.execute(r3);
        ex.execute(r4);
        System.out.println("All work submitted, exiting.");
    }

}
