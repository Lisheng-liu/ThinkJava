package current.sync;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Wait implements Runnable{

    private int count;

    public synchronized void increse(){
        synchronized (this) {
            count++;
        }
    }

    public void print(){
        System.out.println("count:"+count);
    }


    @Override
    public void run() {
        while(true) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:sss").format(new Date())+"  "+",threadName:" + Thread.currentThread().getName() + ",state:" + Thread.currentThread().getState());
            this.increse();
            print();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
