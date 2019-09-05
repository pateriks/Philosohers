package SimpleSync;

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

    @Override
    public String toString() {
        return Integer.toString(shared_variable);
    }
}
