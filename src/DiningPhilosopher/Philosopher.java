package DiningPhilosopher;

import java.util.Random;

public class Philosopher implements Runnable{

    DiningTable diningTable;
    int id;
    Random random = new Random();
    boolean random_active;
    boolean uniformity = false;
    float stupidness = 0.0f;

    public Philosopher(DiningTable dT, int id){
        this.id = id;
        diningTable = dT;
        random_active = true;
    }

    public Philosopher(DiningTable dT, int id, boolean random, boolean uniformity, boolean stupid){
        this.id = id;
        diningTable = dT;
        random_active = random;
        this.uniformity = uniformity;
        if(stupid){
            stupidness = 1.0f;
        }


    }

    @Override
    public void run() {
        while (true){
            if(uniformity || id != 0) {
                while (!diningTable.getChopstic((id + 1)%diningTable.CHOPSTICKS));
                if(stupidness>0.5f){
                    sleep();
                }
                while(!diningTable.getChopstic((id)));
                eat();
                diningTable.releaseChopstic(id);
                diningTable.releaseChopstic((id + 1)%diningTable.CHOPSTICKS);
                sleep();
            }else{
                while (!diningTable.getChopstic((id + 4)));
                while(!diningTable.getChopstic((id)));
                eat();
                diningTable.releaseChopstic(id % diningTable.CHOPSTICKS);
                int stick = (id + 4) % diningTable.CHOPSTICKS;
                diningTable.releaseChopstic(stick);
                sleep();
            }
        }
    }

    public synchronized void eat(){
        try {
            System.out.println(id + " is eating");
            if(random_active) {
                wait(random.nextInt(4000) + 1000);
            }else{
                wait(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void sleep(){
        try {
            System.out.println(id + " is thinking");
            if(random_active) {
                wait(random.nextInt(4000) + 1000);
            }else{
                wait(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
