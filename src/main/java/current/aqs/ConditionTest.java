package current.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

   static ReentrantLock lock = new ReentrantLock();
   static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        lock.lock();
        new Thread(new SingalThread()).start();
        System.out.println("main wait");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        System.out.println("main run ");


    }


   static class SingalThread implements Runnable{
       @Override
       public void run() {
           lock.lock();
           try {
               Thread.sleep(1000*5);
               condition.signal();
               System.out.println("thread run ");
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               lock.unlock();
           }
       }
   }
}