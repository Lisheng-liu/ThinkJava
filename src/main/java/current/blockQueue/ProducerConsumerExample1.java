package current.blockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample1 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new LinkedBlockingQueue(5);

        for(int i = 0; i < 10 ;i++){
            new Thread(new Producer1(blockingQueue),"producer"+i).start();
        }

        for(int i = 0; i < 3 ;i++){
            new Thread(new Consumer1(blockingQueue),"producer"+i).start();
        }

        Thread.sleep(1000*10);


        System.exit(0);


    }


}

class Producer1 implements Runnable{

    private BlockingQueue blockingQueue;

    public Producer1(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
      while (true){
          try {
              Thread.sleep(1000);
              Object o = new Object();
              blockingQueue.add(o);
              System.out.println("cnt p:"+blockingQueue.size());
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }

    }
}

class Consumer1 implements Runnable{

    private BlockingQueue blockingQueue;

    public Consumer1(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                Object o = blockingQueue.take();
                System.out.println("consume "+o);
                System.out.println("cnt c:"+blockingQueue.size());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
