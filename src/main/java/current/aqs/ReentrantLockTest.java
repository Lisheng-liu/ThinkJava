package current.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    static Lock lock = new ReentrantLock(false);

    public static void main(String[] args) {

        for(int i = 0; i< 5; i++){
            new Thread(new ThreadDemo(i)).start();
        }




    }
    static class ThreadDemo implements Runnable{
        Integer id;

        public ThreadDemo(Integer id){
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 2; i++){
                lock.lock();
                System.out.println(lock.tryLock());
                System.out.println("keep lock thread "+id);
                lock.unlock();
                lock.unlock();
            }
        }
    }



}
