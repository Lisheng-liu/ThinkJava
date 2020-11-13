package current.thread;

public class WaitTest2 {

    public static void main(String[] args) {
        Waitt2 waitt2 = new Waitt2(1);
        Thread thread = new Thread(()->{
            waitt2.wait1();
        });
        Thread thread2 = new Thread(()->{
            waitt2.increase(1);
        });

        thread.start();
        thread2.start();



    }




}
class Waitt2{

    private int i;

    private int count;

    public Waitt2(int i){
        this.i = i;
    }

    public void wait1(){
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void increase(int v){
        synchronized (this) {
            System.out.println("thread i"+i+" do...");
            count += v;
        }
    }


    public void notify1(){
        synchronized (this){
            this.notify();
        }
    }
}
