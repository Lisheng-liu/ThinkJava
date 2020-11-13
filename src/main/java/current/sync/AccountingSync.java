package src.current.sync;

public class AccountingSync implements Runnable {

    static int i;

    public  synchronized  void increse(){
        i++;
    }

    @Override
    public void run() {
     for(int j = 0; j < 10000; j++){
         increse();
     }
    }

    public static void main(String[] args) throws InterruptedException {
//        sync();
        for(int k=0; k < 100;k++)
        sync();
    }

    public static void sync() throws InterruptedException {
        AccountingSync accountingSync = new AccountingSync();
        Thread thread1= new Thread(accountingSync);
        Thread thread2 = new Thread(accountingSync);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }

    public static void unsync() throws InterruptedException {
//        AccountingSync accountingSync = new AccountingSync();
        Thread thread1= new Thread(new AccountingSync());
        Thread thread2 = new Thread(new AccountingSync());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
