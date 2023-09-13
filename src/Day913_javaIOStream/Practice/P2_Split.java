package Day913_javaIOStream.Practice;

import java.io.*;

public class P2_Split {
    public static void main(String[] args) {
        e_split("D:\\#Exe_TestFolder\\WeChatFiles.zip",
                "D:\\#Exe_TestFolder\\fileSplit", 1024L * 1024 * 1024 * 3);
    }

    private static void e_split(String sourPath, String tarPath, long len) {
        File sourFile = new File(sourPath);
        File tarFile = new File(tarPath);
        if (!tarFile.exists()) {
            tarFile.mkdirs();
        }
        if (len>= Integer.MAX_VALUE){
            e_lenBiggerThanIntMax(sourFile,tarFile,len);
        }else
            e_lenSmallerThanIntMax(sourFile,tarFile,(int)len);
    }

    private static void e_lenSmallerThanIntMax(File sourFile, File tarFile, int len){
        int size;
        int name = 0;
        byte[] byteSize = new byte[len];
        try (FileInputStream fis = new FileInputStream(sourFile)) {
            while ((size = fis.read(byteSize)) != -1) {
                try (FileOutputStream fos = new FileOutputStream(tarFile.getPath() +
                        File.separator + name++)) {
                    fos.write(byteSize, 0, size);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void e_lenBiggerThanIntMax(File sourFile, File tarFile, long len){
        int size;
//        int name = 0;
        int intLen = lessenLen(len);
        byte[] byteSize = new byte[intLen];
        try(FileInputStream fis = new FileInputStream(sourFile)){
            while ((size = fis.read(byteSize)) != -1){
                try(FileOutputStream fos = new FileOutputStream(tarFile +
                        File.separator + System.currentTimeMillis())){
                    while (tarFile.length() < len){
                        fos.write(byteSize,0,size);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int lessenLen(long len){
        if (len < Integer.MAX_VALUE-8)
            return (int)len;
        return lessenLen(len / 2);
    }

}
