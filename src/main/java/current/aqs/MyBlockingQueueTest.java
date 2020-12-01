package current.aqs;

public class MyBlockingQueueTest {

    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<Integer>(2);
        for(int i = 0; i < 10; i++){
            int data = i;
            new Thread(()->{
                try {
                    queue.enqueue(data
                    );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for(int i = 0; i < 10; i++){

            new Thread(()->{
                try {
                    Integer data = queue.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
