package current.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheTest {
    public static int shareVar = 1;
    public static void main(String[] args)
    {
//        ExecutorService threadPool = Executors.newCachedThreadPool();
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newScheduledThreadPool(5);
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 100; i++)
        {
            threadPool.execute(new Runnable()
            {

                @Override
                public void run()
                {
                    String currentThread = Thread.currentThread().getName();
                    System.out.println("当前是" + shareVar + " " + currentThread);
                    shareVar++;
                }

            });
        }

        threadPool.shutdown();
    }
}

