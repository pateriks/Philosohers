package Concurrency;

/**
 * Creating and joining threads
 * Write a short program that prints "Hello world" from an additional thread using the Java Thread API.
 * Modify the program to print "Hello world" five times, once from each of five different threads. Ensure that the strings are not interleaved in the output.
 * Modify the printed string to include the thread number; ensure that all threads have a unique thread number.
 */

public class Threads {

    public static void main(String [] args) {
        Thread[] hello_world_programs = new Thread[5];
        for (int i = 0; i < hello_world_programs.length; i++) {
            hello_world_programs[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("HELLO WORLD from thread " + Thread.currentThread().getId());
                }
            });
            hello_world_programs[i].start();
        }
    }
}
