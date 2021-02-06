package current.thread;

public class ThreadDemon {

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 5; i++){
          Thread thread =   new Thread(()->{
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("current "+ Thread.currentThread().getName()+" run ..");

                }
            },"thread-"+i);
          thread.setDaemon(true);
//          thread.start();
            thread.run();
        }

        System.out.println("main start ");
        Thread.sleep(1000*10);
        System.out.println("main end ");






    }

}
