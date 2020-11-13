package current.threadPool;

import java.util.concurrent.*;

public class ExectorsTest {

    public static void main(String[] args) {

    }

    public static void test1(){
        ExecutorService e = Executors.newCachedThreadPool();

    }
    public static void test2(){
        ExecutorService e = Executors.newScheduledThreadPool(2);

    }
    public static void test3(){
        ExecutorService e = Executors.newFixedThreadPool(2);

    }

    public static void test4(){
        ExecutorService e = Executors.newScheduledThreadPool(2);

    }

    public static void test5(){
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        ExecutorService e1 = new ThreadPoolExecutor(2,2,2000,TimeUnit.SECONDS,blockingQueue,new ThreadPoolExecutor.AbortPolicy());
        ExecutorService e2 = new ThreadPoolExecutor(2,2,2000,TimeUnit.SECONDS,blockingQueue);

    }
}
