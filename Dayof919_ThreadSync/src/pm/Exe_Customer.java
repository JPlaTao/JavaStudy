package pm;

import java.util.ArrayList;
import java.util.List;

public class Exe_Customer {
    public static void main(String[] args) {
        Desk desk = new Desk();
        Thread c1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        desk.cook();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "樊慧慧");

        Thread c2 = new Thread(() -> {
            while (true) {
                try {
                    desk.cook();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }, "李瑶瑶");

        Thread c3 = new Thread(() -> {
            while (true) {
                try {
                    desk.cook();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "滕嘉巍");

        Thread e1 = new Thread(() -> {
            while (true) {
                try {
                    desk.eat();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "叶辉");

        Thread e2 = new Thread(() -> {
            while (true) {
                try {
                    desk.eat();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "金文涛");

        c1.start();
        c2.start();
        c3.start();

        e1.start();
        e2.start();

    }


}

class Desk {
    private List<String> baoZi = new ArrayList<>();

    public synchronized void cook() throws InterruptedException {
//        while (true) {
            if (baoZi.size() == 0) {
                baoZi.add(System.currentTimeMillis() + "");
                System.out.println(Thread.currentThread().getName()
                        + "做了一个包子：" + baoZi.get(0));
                Thread.sleep(1000);
                notifyAll();
                wait();
            } else {
                notifyAll();
                wait();
            }
//        }
    }

    public synchronized void eat() throws InterruptedException {
//        while (true) {
            if (baoZi.size() == 1) {
                System.out.println(Thread.currentThread().getName()
                        + "吃了一个包子: " + baoZi.get(0));
                baoZi.remove(0);
                Thread.sleep(1000);
                notifyAll();
                wait();
            } else {
                notifyAll();
                wait();
            }
//        }
    }
}
