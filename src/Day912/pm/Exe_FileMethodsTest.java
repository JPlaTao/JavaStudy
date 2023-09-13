package Day912.pm;

import java.io.File;
import java.util.Arrays;

public class Exe_FileMethodsTest {
    public static void main(String[] args) {
        File file = new File("D:\\#Exe_FileTest\\testFile.txt");
        File[] files = file.listFiles();
//        for (File file1 : files) {
//            System.out.println(file1);
//        }
        System.out.println(Arrays.toString(file.listFiles()));
    }
}
