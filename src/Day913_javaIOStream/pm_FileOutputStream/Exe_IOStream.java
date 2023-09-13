package Day913_javaIOStream.pm_FileOutputStream;

import java.io.*;

public class Exe_IOStream {
    public static void main(String[] args) {
        e_copy("D:\\#Exe_TestFolder\\testFile.txt",
                "D:\\#Exe_TestFolder\\copyTest\\testFile_copy.txt");
    }

    private static void e_copy(String sourcePath, String targetPath) {
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        if (!targetFile.getParentFile().exists())
            targetFile.getParentFile().mkdirs();
        try(FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(targetFile)) {
            int size = 0;
            byte[] readBytes = new byte[100];
            while ((size = fis.read(readBytes)) != -1){
                fos.write(readBytes,0,size);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
