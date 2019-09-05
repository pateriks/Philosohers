package SimpleSync;

/**
 * Simple synchronisation
 * Figure out how to use the Java API to extract the number of physical threads available on the CPU you are running on (should be 12 on Tegner).
 * Write a short program in which n threads for n = 2, 6, 12 increment a shared integer repeatedly, without proper synchronisation, 1,000,000 times, printing the resulting value at the end of the program. Run the program on a multicore system and attempt to exercise the potential race in the program.
 * Modify the program to use "synchronized" to ensure that increments on the shared variable are atomic.
 */

public class Main {
    public static void main (String [] args){

        System.out.println(ThreadUtils.size());

        int n = args.length == 0? 10 : Integer.getInteger(args[0]);

        ThreadUtils threadUtils = new ThreadUtils();

        Thread threds [] = new Thread[n];

        for (int i = 0; i < n; i++){
            threds [i] = new Thread(new Incrementer(threadUtils));
            threds [i].start();
        }

        for (Thread thread : threds){
            while (thread.isAlive()){
                Thread.yield();
            }
        }

        System.out.println(threadUtils.toString());
    }
}
