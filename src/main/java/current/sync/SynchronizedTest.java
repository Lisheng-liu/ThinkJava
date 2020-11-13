package current.sync;

public class SynchronizedTest {

    private int count;

    private static int c;

    public synchronized  void add(int v){
        count+=v;
    }

    public void  add1(int v){
        synchronized (this){
            count+=v;
        }
    }
    public static  synchronized void add3(int v){
        c+=v;
    }

    public static void add4(int v){
        synchronized (SynchronizedTest.class){
            c+=v;
        }
    }
}
