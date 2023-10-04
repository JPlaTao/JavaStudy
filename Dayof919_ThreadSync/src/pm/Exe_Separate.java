package pm;

import java.io.*;
import java.util.concurrent.CountDownLatch;

public class Exe_Separate {
    public static void main(String[] args) throws IOException, InterruptedException {
        File sourFile = new File("D:\\4.WorkSpace\\JAVA\\" +
                "java-study\\Dayof919\\src\\sourceFile");
        File tarPath = new File("D:\\4.WorkSpace\\JAVA\\" +
                "java-study\\Dayof919\\src");
        for (int i = 0; i < 10; i++) {
            new sepThread(sourFile,new File(tarPath,
                    String.valueOf(System.currentTimeMillis())),1);
        }
        CountDownLatch latch = new CountDownLatch(10);
        latch.countDown();
        latch.await();
    }
}


class sepThread extends Thread{
    File sourFile;
    File tarFile;
    FileInputStream fis;
    FileOutputStream fos;
    int MBs;
//    byte[] buf = new byte[1024];


    public sepThread(File sourFile, File tarPath, int MBs) throws IOException {
        this.sourFile = sourFile;
        this.tarFile = tarPath;
        fis = new FileInputStream(sourFile);
        fos = new FileOutputStream(tarPath);
        this.MBs = MBs;
    }

    @Override
    public /*synchronized*/ void run() {
        byte[] buf = new byte[MBs * 1024 * 1024];
        try {
            int readByte;
            readByte = fis.read(buf);
            fos.write(buf,0,readByte);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//class fillFile{
//    public static void main(String[] args) throws IOException {
//        File file = new File("D:\\4.WorkSpace\\JAVA\\java-study\\" +
//                "Dayof919\\src\\sourceFile");
//        FileOutputStream fos = new FileOutputStream(file);
//        byte[] buf = new byte[1024 * 1024];
//        for (int i = 0; i < 14; i++) {
//            fos.write(buf);
//        }
//    }
//}