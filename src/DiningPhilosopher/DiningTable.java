package DiningPhilosopher;

import java.util.Arrays;

public class DiningTable {

    int[] chopsAvailibility;
    int CHOPSTICKS;

    public DiningTable(int chopssticks){
        chopsAvailibility = new int[chopssticks];
        CHOPSTICKS = chopssticks;
    }

    synchronized boolean getChopstic(int id){
        if(id > CHOPSTICKS-1){
            System.exit(1);
        }
        if(chopsAvailibility[id] == 0) {
            chopsAvailibility[id] = 1;
            return true;
        }else{
            return false;
        }
    }

    synchronized void releaseChopstic(int id){
        if(id > chopsAvailibility.length){
            System.exit(1);
        }
        chopsAvailibility[id] = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(chopsAvailibility);
    }
}
