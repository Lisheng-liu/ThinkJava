package current.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    private static final int RUN_COUNT = 10;
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(10);

        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10;i++){
            final int no = i+1;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        Thread.sleep((long) (Math.random()*10000));
                        System.out.println("no"+no+ " arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            executorService.submit(run);
        }
        System.out.println("game start");
        begin.countDown();
        end.await(30, TimeUnit.SECONDS);
        System.out.println("Game over");
        executorService.shutdown();


    }

}
