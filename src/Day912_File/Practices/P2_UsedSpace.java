package Day912_File.Practices;

import java.io.File;

public class P2_UsedSpace {
    public static void main(String[] args) {
//        allFileLength("d:/#Exe_FileTest");
        allFileLength("D:\\1.Applications");
    }

    public static void allFileLength(String direPath){
        System.out.printf("total length:%.2fMB",getFileLength(direPath)/1024.0/1024);
    }

    private static double getFileLength(String direPath){
        File file = new File(direPath);
        double sum = 0;
        if (file.isFile())
            return file.length();
        File[] filesList = file.listFiles();
        for (File files : filesList) {
            if (files.isFile())
                sum += files.length();
            else
                sum += getFileLength(files.getAbsolutePath());
        }
        return sum;
    }
}
