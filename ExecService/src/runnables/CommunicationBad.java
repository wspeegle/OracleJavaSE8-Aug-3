package runnables;

public class CommunicationBad {
    public static void main(String [] args) {
        Runnable r = new Runnable() {
            int i = 0;
            @Override
            public void run() {
                for (/*int i = 0*/;i < 10_000; i++) {
                    System.out.println(Thread.currentThread().getName() 
                        + " i is " + i);
                }
            }
        };
        new Thread(r).start();
        new Thread(r).start();
    }
}
