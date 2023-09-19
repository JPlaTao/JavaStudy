package Practice;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class P2_Test {
//    编写⼀个多线程程序，可以并⾏处理⼤量⽂本⽂件。
//    每个线程负责读取⼀个⽂件，进⾏处理，然后将结果写⼊输出⽂件。
    public static void main(String[] args) {
        File tarFile = new File("D:\\4.WorkSpace\\JAVA" +
                "\\java-study\\Dayof919\\src\\result");
        FileDealer fileDealer = new FileDealer(tarFile);

        Thread t1 = new Thread(()->{
            fileDealer.deal(new File("D:\\4.WorkSpace\\JAVA\\" +
                    "java-study\\Dayof919\\src\\chapter1"));
        });

        Thread t2 = new Thread(()->{
            fileDealer.deal(new File("D:\\4.WorkSpace\\JAVA\\" +
                    "java-study\\Dayof919\\src\\chapter2"));
        });
        t1.start();
        t2.start();
    }
}

class FileDealer{
    Lock lock = new ReentrantLock();
    File tarFile;
    FileDealer(File tarFile){
        this.tarFile = tarFile;
    }
    void deal(File sourFile){
        lock.lock();
        try(FileInputStream fis = new FileInputStream(sourFile);
            FileOutputStream fos = new FileOutputStream(tarFile,true)
        ){
            int readByte = 0;
            byte[] buf = new byte[1024];
            while ((readByte = fis.read(buf)) > 0){
                fos.write(buf,0,readByte);
            }
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        lock.unlock();
    }
}
