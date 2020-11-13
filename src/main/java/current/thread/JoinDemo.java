package current.thread;

public class JoinDemo extends Thread{
    int i;
    Thread previousThread; //上一个线程
    public JoinDemo(Thread previousThread,int i){
        this.previousThread=previousThread;
        this.i=i;
    }
    @Override
    public void run() {
        try {
            //调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num:"+i);
    }
    public static void main(String[] args) throws InterruptedException {
//        joinControl();
        testJoin();

    }

    public static  void joinControl (){
        Thread previousThread=Thread.currentThread();
        for(int i=0;i<10;i++){
            JoinDemo joinDemo=new JoinDemo(previousThread,i);
            joinDemo.start();
            previousThread=joinDemo;
        }
    }

    public static void testJoin() throws InterruptedException {
//        for(int i =0; i < 10; i++){
            Thread thread = new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            },"t1");

        Thread thread2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"t2");

        thread.start();thread2.start();
        thread.join();thread2.join();

//        }

    }
}

