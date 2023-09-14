package Day914.am;

import java.io.*;

public class Exe_splitNew {
    public static void main(String[] args) {

    }

    private static void split(File sourFile, File tarPath, long len) {
        int readSize;
        byte[] readBytes;
        if (len > Integer.MAX_VALUE) {
            long sum = len;
            try (FileInputStream fis = new FileInputStream(sourFile)) {
                readBytes = new byte[Integer.MAX_VALUE - 8];
                try (FileOutputStream fos = new FileOutputStream(
                        tarPath + File.separator + System.currentTimeMillis())) {
                    while (sum > Integer.MAX_VALUE - 8 && fis.available() > 0) {
                        readSize = fis.read(readBytes);
                        if (readSize < 0) {
                            break;
                        }
                        fos.write(readBytes);
                        sum -= (Integer.MAX_VALUE - 8);
                    }
                    if (fis.available() > 0) {
                        fos.write(fis.readAllBytes());
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try (FileInputStream fis = new FileInputStream(sourFile)) {
                readBytes =new byte[(int)len];
                while ((readSize = fis.read(readBytes)) >0 ){
                    try(FileOutputStream fos = new FileOutputStream(
                            tarPath + File.separator + System.currentTimeMillis())){
                        fos.write(readBytes);
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
