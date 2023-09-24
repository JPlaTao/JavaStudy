package Pracitce.imafkidiot;

class TestForCP {
    public static void main(String[] args) {
        ShardData shardData = new ShardData();
        new Consumer(shardData).start();
        new Producer(shardData).start();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                5,8,3, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(8)
//        );
//        threadPoolExecutor.execute(new Consumer(shardData));
//        threadPoolExecutor.execute(new Consumer(shardData));
//        threadPoolExecutor.execute(new Consumer(shardData));
//        threadPoolExecutor.execute(new Producer(shardData));
//        threadPoolExecutor.execute(new Producer(shardData));
    }
}

//class MyThreadFactory implements ThreadFactory{
//
//    @Override
//    public Thread newThread(Runnable r) {
//
//    }
//}

class Producer extends Thread{
    private ShardData s;
    public Producer(ShardData s){
        this.s = s;
    }

    @Override
    public void run() {
        for (char ch = 'A';ch <= 'Z';ch++){
            try {
                Thread.sleep((int)(Math.random()*3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s.put(ch);
        }
    }
}

class Consumer extends Thread{
    private ShardData s;
    public Consumer(ShardData s){
        this.s = s;
    }

    @Override
    public void run() {
        char ch;
        do{
            try {
                Thread.sleep((int)(Math.random()*3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ch = s.get();
        }while (ch != 'Z');
    }
}

class ShardData{
    private char c;
    private boolean isProduced = false;

    public synchronized void put(char c){
        if(isProduced){
            System.out.println("消费者还未消费，因此生产者停止生产");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.c = c;
        isProduced = true;
        notify();
        System.out.println("生产者生产了产品: " + c + ", 通知消费者消费...");
    }

    public synchronized char get(){
        if (!isProduced){
            System.out.println("生产者尚未生产，消费者停止消费");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isProduced = false;
        notify();
        System.out.println("消费者消费了产品: " + c + ", 通知生产者生产");
        return this.c;
    }
}