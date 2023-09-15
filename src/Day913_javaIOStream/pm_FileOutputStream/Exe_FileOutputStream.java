package Day913_javaIOStream.pm_FileOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exe_FileOutputStream {
    public static void main(String[] args) {
        String pathName = "D:\\#Exe_TestFolder\\TestFolderLv2\\testFile.txt.txt";
        File file = new File("D:\\#Exe_TestFolder\\TestFolderLv2\\testFile.txt.txt");
//        System.out.println(file.getParent());
//        System.out.println(file.getParentFile());
        e_fileOutputStream(pathName);
    }

    private static void e_fileOutputStream(String pathName){
        File file = new File(pathName);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream(file,true)) {
            byte[] bytes = "瑶瑶领先huawei mete 60+".getBytes();
            byte[] bytes1 = "毫无创新iphone pro max".getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.write(bytes1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
