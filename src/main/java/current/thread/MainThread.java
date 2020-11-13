package current.thread;

public class MainThread {
//    Logger logger = LoggerFactory.getLogger(MainClass.class);


    public static void main(String[] args) {


        Thread t = new Thread(new LiftOff());
        t.start();
        t.setName("lift off thread");
        System.out.println("waiting for liftoff");
    }
}
class LiftOff implements Runnable {

//    Logger logger = LoggerFactory.getLogger(LiftOff.class);

    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }
    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.println(status());
//            Thread.yield();
        }
    }
}