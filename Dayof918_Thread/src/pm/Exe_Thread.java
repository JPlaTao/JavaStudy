package pm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Exe_Thread1 {
    public static void main(String[] args)  {
//        System.out.println("main thread");
//        Thread newThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("new thread");
//            }
//        });
//        newThread.start();
//        for (int i = 0; i < 10; i++) {
////            Thread.sleep(500);
//            System.out.println(i);
//        }
        Thread.currentThread().setName("主线程");
        Thread myThread = new Thread(()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()
                    + "运行到第" + i + "次");
            }
        });
        myThread.setName("子线程");
        myThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()
                    + "运行到第" + i + "次");
        }
    }
}


class Exe_Runnable{
    public static void main(String[] args) {
        Thread.currentThread().setName("main thread");
        Thread t = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()
                        + "运行到第" + i + "次");
            }
        });

        t.setName("sub threat");
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()
                    + "运行到第" + i + "次");
        }
    }
}

class Exe_Callable{

    public static void main(String[] args) {
        Callable<Integer> callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i <= 10; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
