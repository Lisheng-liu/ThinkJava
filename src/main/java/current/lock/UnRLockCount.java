package current.lock;

public class UnRLockCount {

    UnReentrantLock lock = new UnReentrantLock();
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

        UnRLockCount count = new UnRLockCount();
        try {
            count.print();
            count.doAdd();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
