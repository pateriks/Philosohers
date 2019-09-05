package ProdCons;

public class ThreadUtils {
    int shared_variable;

    public static int size(){
        return Thread.activeCount();
    }

    public void inc(){
        shared_variable++;
    }

    synchronized public void sync_inc(){
        shared_variable++;
    }

    synchronized public String consume(){
        if(shared_variable < 1000000){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Integer.toString(shared_variable);
    }

    synchronized public void done (){
        notify();
    }

    @Override
    public String toString() {
        return Integer.toString(shared_variable);
    }
}
