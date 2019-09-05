package ProdCons;

public class Incrementer implements Runnable{
    ThreadUtils tu;

    public Incrementer(ThreadUtils tu){
        this.tu = tu;
    }

    @Override
    synchronized public void run() {
        for(int i = 0; i < 1000000; i++) {
            tu.sync_inc();
        }
        tu.done();
    }
}
