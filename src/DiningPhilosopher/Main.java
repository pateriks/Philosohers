package DiningPhilosopher;

public class Main {

    public static void main(String[] args) {
        Thread[] phils = new Thread[5];
        DiningTable dT = new DiningTable(5);
        for(int i = 0; i < 5; i++) {
            Philosopher philosopher = new Philosopher(dT, i);
            Thread t = new Thread(philosopher);
            phils[i] = t;
            phils[i].start();
        }
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(dT.toString());
        }
    }
}
