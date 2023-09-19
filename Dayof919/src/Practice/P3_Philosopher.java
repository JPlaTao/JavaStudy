package Practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//模拟哲学家就餐问题，创建⼀个多线程程序，模拟多位哲学家在圆桌上就餐。
//每个哲学家都必须先拿起左边的筷⼦，再拿起右边的筷⼦才能吃饭。
//使⽤互斥锁来确保筷⼦的互斥访问。
class p3_Test{
    public static void main(String[] args) {
//        Philosopher philosopher = new Philosopher();
//        Thread p1 = new Thread(()->{
//            while (true){
//                philosopher.eat();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        },"黑格尔");
//
//        Thread p2 = new Thread(()->{
//            while (true){
//                philosopher.eat();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        },"加缪");
//
//        Thread p3 = new Thread(()->{
//            while (true){
//                philosopher.eat();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//        },"亚里士多德");
//
//        Thread p4 = new Thread(()->{
//            while (true){
//                philosopher.eat();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        },"柏拉图");
//
//        p3.start();
//        p1.start();
//        p4.start();
//        p2.start();
    }

}
class Philosopher {
    Lock lock = new ReentrantLock();
    void eat(){
        if (lock.tryLock()){
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "正在吃饭");
            lock.unlock();
        }else
            System.out.println(Thread.currentThread().getName() + "正在思考");
    }
}

