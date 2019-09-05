package Semaphores;

/**
 * A (counting) semaphore is a shared variable with two atomic operations signal() and wait().
 * Semaphores are used to govern access to some shared resource.
 * A positive value n of the semaphore indicates that there are n amounts of resource available. signal() increments the value of the semaphore by 1 to indicate that a resource has been made available.
 * This causes a waiting thread to be activated, if at time of calling signal() the value of the semaphore was negative. wait() decrements the value of the semaphore by 1.
 * If the value of the semaphore is now negative, the calling thread is suspended.
 * Implement a counting semaphore using synchronized(), wait(), and notify() in Java, and test it on a suitably simple example..
 */
public class Main {
    public static void main (String [] args){

        Semaphore sem = new Semaphore(2);

        for (int i = 0; i < 3; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    sem.Signal();
                    if(Thread.currentThread().getId()%2 == 0){
                        System.out.println("THREAD " + Thread.currentThread().getId() + " blocking");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("HELLO WORLD from thread " + Thread.currentThread().getId());
                    sem.Release();

                }
            }).start();
        }

    }
}
