package Day912_File.Practices;

import java.io.File;

public class P1_Directors {
    public static void main(String[] args) {
        directoryFifo("D:\\#Exe_FileTest");
//        directoryFifo("D:\\");
    }

    private static void directoryFifo(String direPath){
        String retract = "";
        directoryFifo(direPath,retract);
    }

    private static void directoryFifo(String direPath,String retract){
        File file = new File(direPath);
        if (file.isFile())
            return;
        File[] listFile = file.listFiles();
        if (listFile == null)
            return;
        retract += "\t";
        for (File files : listFile) {
            if (files.isFile())
                System.out.println(retract + files.getName());
            if (files.isDirectory())
                System.out.println(retract + files.getAbsolutePath());
            directoryFifo(files.getAbsolutePath(),retract);
        }
    }
}
