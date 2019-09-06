package ProdCons;

public class Consumer implements Runnable {
    ThreadUtils tu;
    Boolean buffered_consume;
    public Consumer (ThreadUtils tu){
        this.tu = tu;
    }
    public Consumer (ThreadUtils tu, boolean bufferedConsume){
        this.tu = tu;
        this.buffered_consume = bufferedConsume;
    }

    @Override
    synchronized public void run() {
        if(!buffered_consume) {
            System.out.println("Consumer out " + tu.consume());
        }else {
            while (tu.last_read_index < 10) {
                System.out.println("Consumer out " + tu.bufferConsume());
            }
        }
    }
}
