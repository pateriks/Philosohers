package ProdCons;

public class Consumer implements Runnable {
    ThreadUtils tu;
    public Consumer (ThreadUtils tu){
        this.tu = tu;
    }

    @Override
    synchronized public void run() {
        System.out.println("Consumer out " + tu.consume());
    }
}
