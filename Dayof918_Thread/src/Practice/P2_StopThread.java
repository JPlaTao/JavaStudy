package Practice;

import java.util.concurrent.*;

//创建一个线程循环对一个数做加一操作，5秒后,在主线程中,中断线程,并在主线程（main）输出结果。
class StopThread1 {
    public static void main(String[] args) {
        System.out.println("主线程开始");
        Thread t1 = new Thread(()->{
            System.out.println("子线程开始");
            int num = 0;
            while (true){
                num++;
            }
        });

        t1.start();
        try {
            Thread.sleep(5000);
            //t1.stop();
            System.out.println("子线程结束");
        } catch (InterruptedException e) {
            System.out.println("子线程结束");
        }
        System.out.println("主线程结束");
    }
}
class StopThread2 {
    static boolean stop = true;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("主线程开始");
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                while (stop){
                    sum ++;
                }
                return sum;
            }
        });

        Thread t1 = new Thread(futureTask);
        t1.start();
        Thread.sleep(2000);
        stop = false;
        System.out.println("子线程结束，结果为：" + futureTask.get());
        t1.stop();
        System.out.println("主线程结束");
    }
}
