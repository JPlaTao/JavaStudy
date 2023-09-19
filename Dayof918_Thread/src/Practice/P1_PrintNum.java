package Practice;

public class P1_PrintNum {
    //创建两个线程，一个打印偶数，另一个打印奇数（范围从1到10）
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 100; i += 2) {
                System.out.println("偶数" + i);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i += 2) {
                    System.out.println("偶数" + i);
                }
            }
        });
        t2.start();
    }

}
