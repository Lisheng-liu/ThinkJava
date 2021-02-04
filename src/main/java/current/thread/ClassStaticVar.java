package current.thread;

public class ClassStaticVar
{
    private static int static_i;//静态变量

    public static  void test()
    {
        static_i = 4;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取static_i 的值:" + static_i);
        static_i = 10;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取static_i*3的值:" + static_i * 2);
    }

    public static void main(String[] args)
    {
//        ClassStaticVar t = new ClassStaticVar();
        //启动尽量多的线程才能很容易的模拟问题
        for (int i = 0; i < 3000; i++)
        {
            //t可以换成new Test(),保证每个线程都在不同的对象中执行，结果一样
//            new Thread(t, "线程" + i).start();
            new Thread(()->{
                ClassStaticVar.test();
            }).start();
        }
    }
}
