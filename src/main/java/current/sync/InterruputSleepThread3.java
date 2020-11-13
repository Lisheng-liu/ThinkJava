package current.sync;

import java.util.concurrent.TimeUnit;

public class InterruputSleepThread3 {
    public static void main(String[] args) throws InterruptedException {
//        threadName();

//        threadWait();
//        threadDoInterupt3();
//        threadDoInterupt2();
//        threadDoInterupt1();
    }



    public static void threadException() throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.out.println(1/0);
        });
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(1000);
        System.out.println(thread.getState());

    }
    public static void threadName() throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadName:" + Thread.currentThread().getName() + ",state:" + Thread.currentThread().getState());
            }
            });
        thread.start();
        System.out.println("threadName:"+thread.getName()+",state:"+thread.getState());
        System.out.println("threadName1:" + Thread.currentThread().getName() + ",state:1" + Thread.currentThread().getState());
        for(int i = 10; i< 100;i++){
            Thread.sleep(2000);
            System.out.println("threadName:"+thread.getName()+"state:"+thread.getState());
            System.out.println("threadName1:" + Thread.currentThread().getName() + ",state:1" + Thread.currentThread().getState());
        }


    }

    public static void threadWait() throws InterruptedException {
        Wait wait = new Wait();
        Thread thread = new Thread(wait);
        Thread thread2 = new Thread(wait);
        thread.start();
        thread2.start();
        Thread.sleep(2000);
        thread.wait();

        Thread.sleep(2000*10);
        thread.notify();

    }


    public static void threadDoInterupt3() throws InterruptedException {
      Thread thread = new Thread(()->{
         while (true){
             if(Thread.currentThread().isInterrupted()){
                 System.out.println("break zd");
                 break;
             }
/*             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }*/
             System.out.println("n zd");
         }
          System.out.println("zd");
      });

      thread.start();
      Thread.sleep(2000);
      thread.interrupt();
//      thread.
    }

    public static void threadDoInterupt2() throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("break zd");
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("n zd");
            }
            System.out.println("zd");
        });

        thread.start();
        Thread.sleep(2000);
//        thread.interrupt();
    }

    public static void threadDoInterupt1() throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true){
              /*  if(Thread.currentThread().isInterrupted()){
                    System.out.println("break zd");
                    break;
                }*/
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("n zd");
            }
//            System.out.println("zd");
        });

        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    }



