package am;

import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.SortedMap;
import java.util.concurrent.*;

public class Exe_ThreadPool {
    public static void main(String[] args) {
        e_ExecutorService();
    }

    static void e_ExecutorService(){
        ExecutorService pool = Executors.newCachedThreadPool();
        System.out.println("当前时间" + LocalTime.now());
        for (int i = 0; i < 10; i++) {
            int number = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前时间" + LocalTime.now() + "线程: " +
                            Thread.currentThread().getName() + ",序号：" + number);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    void e_ThreadPollExecutor(){
        ArrayBlockingQueue<Runnable> ArrayDeque = new ArrayBlockingQueue<Runnable>(5);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                3,
                8,
                1000L, TimeUnit.MILLISECONDS,
                ArrayDeque,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 100; i++) {
            int id = i;
            poolExecutor.submit(()->{
                System.out.println("Executing task: " + id
                        + "by thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        poolExecutor.shutdown();
    }


    static void e_SingletThread(){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

    }


}
class MyThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}
