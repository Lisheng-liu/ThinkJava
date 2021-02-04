package current.thread;

import java.util.LinkedList;
import java.util.List;

public class ClassStaticVar2
{
    private static List<String> LIST;//静态变量

    public static  void test()
    {
        LIST = new LinkedList<>();
        System.out.println("[" + Thread.currentThread().getName()
                + "]LIST 的size1:" + LIST.size());
        LIST.add("a");
        LIST.add("b");
        System.out.println("[" + Thread.currentThread().getName()
                + "]LIST 的size2:" + LIST .size());
    }

    public static void main(String[] args)
    {
//        ClassStaticVar2.test();
//        ClassStaticVar t = new ClassStaticVar();
        //启动尽量多的线程才能很容易的模拟问题
        for (int i = 0; i < 3000; i++)
        {
            //t可以换成new Test(),保证每个线程都在不同的对象中执行，结果一样
//            new Thread(t, "线程" + i).start();
            new Thread(()->{
                ClassStaticVar2.test();
            }).start();
        }
    }
}
