package current.thread;

public class IsAliveTest
{
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(()->{

            System.out.println("alive: "+Thread.currentThread().isAlive());
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        t.start();
        t.join();

        System.out.println("thread t status = " + t.isAlive());
        System.out.println("thread main status = " + Thread.currentThread().isAlive());




    }

}
