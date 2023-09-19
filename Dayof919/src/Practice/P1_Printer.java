package Practice;

import java.util.Random;

//创建两个线程，⼀个线程负责打印数字，另⼀个线程负责打印字母。
//确保它们交替执⾏，并使用线程通信来协调它们。
class P1_Test {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread letter = new Thread(() -> {
            while (true) {
                printer.letter();
            }
        });

        Thread number = new Thread(() -> {
            while (true) {
                printer.number();
            }
        });

        letter.start();
        number.start();
    }
}

class Printer {
    public synchronized void letter() {
        char c = 0;
        Random random = new Random();
        int op = random.nextInt(0, 2);
        switch (op) {
            case 0 -> c = (char) random.nextInt(97, 122);
            default -> c = (char) random.nextInt(65, 90);
        }
        System.out.print(c);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void number() {
        int num = 0;
        Random random = new Random();
        num = random.nextInt(0, 9);
        System.out.print(num);
        notify();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

