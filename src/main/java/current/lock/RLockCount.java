package current.lock;

public class RLockCount {

    ReentrantLock lock = new ReentrantLock();
    public void print() throws InterruptedException {
        lock.lock();
        doAdd();
        lock.unlock();
    }
    public void doAdd() throws InterruptedException {
        lock.lock();
        //do something
        lock.unlock();
    }

    public static void main(String[] args) {

        RLockCount count = new RLockCount();
        try {
            count.print();
            count.doAdd();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
