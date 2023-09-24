package Pracitce.imafkidiot;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TestForP2 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, 5, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5));

        BaoZi baoZi = new BaoZi();
        executor.execute(new Cooker(baoZi));
        executor.execute(new Cooker(baoZi));
        executor.execute(new Eater(baoZi));
        executor.execute(new Eater(baoZi));
        executor.execute(new Eater(baoZi));
    }
}

class BaoZi {
    Lock lock = new ReentrantLock();
    LinkedBlockingDeque<String> baoZi = new LinkedBlockingDeque<>(1);
    int modCount = 1;

    synchronized boolean cook() {
        lock.lock();
        if (baoZi.isEmpty()) {
            try {
                baoZi.put("包子" + modCount++);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
            return true;
        } else {
            lock.unlock();
            return false;
        }
    }

    boolean eat() {
        if (baoZi.size() == 1) {
            try {
                baoZi.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            lock.unlock();
            return false;
        }
    }

    String getBaoZi() {
        return baoZi.getLast();
    }
}

class Eater implements Runnable {
    BaoZi baozi;

    public Eater(BaoZi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while (true) {
            if (baozi.eat()) {
                System.out.println(Thread.currentThread().getName() +
                        ": 吃了一个包子: "/* + baozi.getBaoZi()*/);
            }
        }
    }
}

class Cooker implements Runnable {
    BaoZi baozi;

    public Cooker(BaoZi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while (true) {
            if (baozi.cook()) {
                System.out.println(Thread.currentThread().getName() +
                        ": 做了一个包子: " + baozi.getBaoZi());
            }
        }
    }
}