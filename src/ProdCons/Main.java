package ProdCons;

/**
 * Guarded blocks
 * Write a short program in which one thread increments an integer 1,000,000 times, and a second thread prints the integer -- without waiting for it to finish.
 * Modify the program to use a condition variable to signal completion of the incrementing task by the first thread before the second thread prints the value.
 */
public class Main {

    public static void main (String [] args){
        ThreadUtils threadUtils = new ThreadUtils();

        Thread incrementer = new Thread(new Incrementer(threadUtils, true));
        Thread consumer = new Thread(new Consumer(threadUtils, true));

        consumer.start();
        incrementer.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main out: " + threadUtils.toString());

    }
}
