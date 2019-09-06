package ProdCons;

import java.io.BufferedReader;

public class Incrementer implements Runnable{
    ThreadUtils tu;
    boolean buffered_write = false;
    public Incrementer(ThreadUtils tu){
        this.tu = tu;
    }

    public Incrementer(ThreadUtils tu, boolean buffered_write){

        this.tu = tu;
        this.buffered_write = buffered_write;
    }

    @Override
    synchronized public void run() {
        if(!buffered_write) {
            for (int i = 0; i < 1000000; i++) {
                tu.sync_inc();
            }
            tu.done();
        }else{
            for(int i = 0; i < 10; i++) {
                tu.bufferProduce();
                try {
                    wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tu.done();

            }
        }
    }
}
