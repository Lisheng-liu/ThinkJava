package current.sync;

public class staticSync {

    static int count;
    public synchronized static  void dosth(){
        synchronized (staticSync.class) {
            System.out.println();
        }
    }
}
