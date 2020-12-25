package current.aqs;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTt {


    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        Thread[] students101 = new Thread[5];
        for(int i = 0; i < 20; i++){
            if(i < 10){
                new Thread(new Student("打饭学生"+i,semaphore,0)).start();
            }else if ( i >= 10 && i < 15){
                new Thread(new Student("泡面"+i,semaphore,1)).start();
            }else{
                students101[i - 15] = new Thread(new Student("聚餐学生" + i, semaphore, 2));
                students101[i - 15].start();
            }
        }
        Thread.sleep(5000);
        for (int i = 0; i < 5; i++) {
            students101[i].interrupt();
        }



    }



    static class Student implements Runnable{

        private String name;

        private Semaphore semaphore;

        /**
         * 打饭方式
         * 0    一直等待直到打到饭
         * 1    等了一会不耐烦了，回宿舍吃泡面了
         * 2    打饭中途被其他同学叫走了，不再等待
         */
        private int type;

        public Student(String name, Semaphore semaphore, int type) {
            this.name = name;
            this.semaphore = semaphore;
            this.type = type;
        }


        @Override
        public void run() {
            switch (type){
                case 0:
                    semaphore.acquireUninterruptibly();
                    try {
                        Thread.sleep(1000*10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                    System.out.println(name+" 打到饭");
                    break;
                case 1:
                    try {
                        if(semaphore.tryAcquire(new Random().nextInt(),TimeUnit.SECONDS)){
                            try {
                                Thread.sleep(1000*10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            semaphore.release();
                            //打到了饭
                            System.out.println(name + " 终于打到了饭.");

                    }else{
                            System.out.println(name + " 回宿舍吃泡面.");
                     }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        System.out.println(name + " 全部聚餐，不再打饭.");
                    }
                    semaphore.release();
                    //打到了饭
                    System.out.println(name + " 终于打到了饭.");


            break;
            default:
            break;
            }



        }
    }

}
