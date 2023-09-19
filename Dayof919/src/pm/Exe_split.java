package pm;

import java.io.*;
import java.util.Arrays;

public class Exe_split {
    public static void main(String[] args) {
        Split split = new Split(new File("D:\\#Exe_TestFolder\\videoTest\\video1.mp4"), 2);
        split.cut();
    }
}

class Split {
    File sourFile;
    int MBs;

    Split(File sourFile, int MBs) {
        this.sourFile = sourFile;
        this.MBs = MBs;
    }

    void cut() {
        try (FileInputStream fis = new FileInputStream(sourFile);) {
            byte[] buff = fis.readAllBytes();
            int i = 0;
            while (i<= buff.length) {
                File subFile = new File(sourFile.getParentFile(),
                        System.currentTimeMillis() + "");
                byte[] writeBuff = new byte[MBs * 1024 * 1034];
                System.arraycopy(buff, i, writeBuff,0,writeBuff.length);
                i+= writeBuff.length;
                new Thread(() -> {
                    try(FileOutputStream fos = new FileOutputStream(subFile)) {
                        fos.write(writeBuff);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
