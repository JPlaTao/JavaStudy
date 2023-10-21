package Practice;

import java.util.concurrent.*;

//创建一个线程循环对一个数做加一操作，5秒后,在主线程中,中断线程,并在主线程（main）输出结果。
class StopThread1 {
    public static void main(String[] args) {
        System.out.println("主线程开始");
        Thread t1 = new Thread(() -> {
            System.out.println("子线程开始");
            long num = 0;
            while (true) {
                num++;
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(num);
                    System.out.println("子线程结束");
                    break;
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(5000);
            //t1.stop();
            t1.interrupt();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("主线程结束");
    }
}

class StopThread2 {
    static boolean stop = true;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("主线程开始");
        FutureTask<Long> futureTask = new FutureTask<>(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                Long sum = 0L;
                while (true) {
                    sum++;
                    if (Thread.currentThread().isInterrupted())
                        return sum;
                }
            }
        });

        Thread t1 = new Thread(futureTask);
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
        System.out.println("子线程结束，结果为：" + futureTask.get());
        System.out.println("主线程结束");
    }
}
