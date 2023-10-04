package Pracitce.imafkindiot;
import java.util.concurrent.LinkedBlockingDeque;

class Test{
    public static void main(String[] args) {
        Desk desk = new Desk();
//        ExecutorService pool = Executors.newSingleThreadExecutor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    desk.cooker();
                }
            }
        },"库克");
        Thread t2 = new Thread(()->{
            while (true){
                desk.eater();
            }
        },"伊特尔");
        t1.start();
        t2.start();
    }
}
class Desk{
    private LinkedBlockingDeque<String> desk = new LinkedBlockingDeque<>();
    public void cooker(){
        if (desk.size() == 0){
            desk.add(System.currentTimeMillis() + "");
            System.out.println(Thread.currentThread().getName() +
                    "做了一个包子: " + desk.getLast());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void eater(){
        if (desk.size() == 1){
            System.out.println(Thread.currentThread().getName() +
                    "吃了一个包子" + desk.getLast() );
            desk.removeLast();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
//class Cooker implements Runnable{
//    private LinkedBlockingDeque<String> workQueue;
//    Cooker(String name, LinkedBlockingDeque<String> workQueue){
//        Thread.currentThread().setName(name);
//        this.workQueue = workQueue;
//    }
//
//    @Override
//    public void run() {
//        while (true){
//            cook();
//        }
//    }
//    private void cook(){
//        if (workQueue.size() == 0){
//            workQueue.add(System.currentTimeMillis() + "");
//            System.out.println(Thread.currentThread().getName() + "做了一个包子");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//}
//class Eater{
//}