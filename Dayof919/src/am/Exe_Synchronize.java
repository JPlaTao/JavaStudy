package am;

public class Exe_Synchronize {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                synchronized (counter){
                    counter.autoPlus();
                    System.out.println("t1: " + counter.getNum());
//                }
            }
        });
        Thread t2 = new Thread(() -> {
//            synchronized (counter){
                counter.autoMinus();
                System.out.println("t2: " + counter.getNum());
//            }
        });
        t1.start();
        t2.start();
        System.out.println("main: " + counter.getNum());
    }
    static class Counter {
        private int num = 55;

        /*synchronized*/ void autoPlus() {
            for (int i = 0; i < 10000; i++) {
                num++;
            }
//            return num;
        }

        /*synchronized*/ void autoMinus() {
            for (int i = 0; i < 10000; i++) {
                num--;
            }
//            return num;
        }

        public int getNum() {
            return num;
        }
    }
}
