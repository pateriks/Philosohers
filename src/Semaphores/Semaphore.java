package Semaphores;

public class Semaphore {

    int value;

    public Semaphore (int resources){
        value = resources;
    }

    synchronized public void Signal (){
        if(value>=1) {
            value--;
        }else{
            try {
                wait();
                Signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public void Release (){
        value++;
        notify();
    }

}
