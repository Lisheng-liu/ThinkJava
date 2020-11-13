package current.thread;

import current.sync.Wait;

public class WaitTest {

    public static void main(String[] args) throws InterruptedException {

//        testWaitLock();



    }

    public static void testWaitLock2() {
        new Thread(new Wait1()).start();
        new Thread(new Wait2()).start();
    }

   public static void testWaitLock(){
        Waitthread wait = new Waitthread();
        Thread test1 = new Thread(wait,"线程1");
        Thread test2 = new Thread(wait,"线程2");
        Thread test3 = new Thread(wait,"线程3");
        Thread test4 = new Thread(wait,"线程4");
        Thread test5 = new Thread(wait,"线程5");

        test1.start();
        test2.start();
        test3.start();
        test4.start();
        test5.start();
   }

    public static class Wait1 implements Runnable{
        /**
         * 实现体育老师安排体育课代表进行点名
         */
        @Override
        public void run() {
            // TODO Auto-generated method stub
            //这个步骤我们可以想象成锁住的是一节体育课
            /*synchronized (WaitTest.class) {
                System.out.println("体育老师安排体育委员进行点名");
                try {
                    //体育老师在楼下等待,并且交出体育课的锁。等待体育课代表告诉他点名结束,他开始接管这节体育课
                    WaitTest.class.wait(1000*10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch  block
                    e.printStackTrace();
                }
                System.out.println("体育老师得到点名的结果开始上课");
            }*/
            synchronized (WaitTest.class){
                System.out.println("体育老师安排体育委员进行点名");
                try {
                    WaitTest.class.wait();
//                    WaitTest.class.wait(1000*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("体育老师得到点名的结果开始上课");
        }

    }

    public static class Wait2 implements Runnable{

        /**
         * 实现体育课代表进行队列点名
         */
        @Override
        public void run() {
            // TODO Auto-generated method stub
            synchronized (WaitTest.class) {
                System.out.println("体育委员进行点名");

                try {
                    //点名需要花费的时间
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch  block
                    e.printStackTrace();
                }
                System.out.println("体育委员点名结束");
                //通知体育老师点名结束了
//                WaitTest.class.notify();
//
                System.out.println("体育课代表带人去操场");
            }
        }


    }

}
class Waitthread implements Runnable {
//    private Object lock = new Object();

    /**
     * 实现run方法
     */

    public void run() {
        // TODO Auto-generated method stub
        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "开始了");
                this.wait();
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束了");
    }
}