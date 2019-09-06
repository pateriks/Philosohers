package ProdCons;

import java.util.Random;

public class ThreadUtils {
    int shared_variable;
    int [] fixed_size_buffer = new int[10];
    int buffer_index = -1;
    int last_read_index = 0;
    Random int_generator = new Random(System.currentTimeMillis());

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

    synchronized public String bufferConsume (){
        if(buffer_index<last_read_index){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return bufferConsume();
        }
        return Integer.toString(fixed_size_buffer[last_read_index++]);
    }

    public void bufferProduce(){
        fixed_size_buffer[++buffer_index] = int_generator.nextInt(10);
    }

    synchronized public void done (){
        notify();
    }

    @Override
    public String toString() {
        return Integer.toString(shared_variable);
    }
}
