package Practices;

import java.io.File;

public class P4_Delete {
    public static void main(String[] args) {
        delete("D:\\#Exe_FileTest\\Folder - 副本 (3) - 副本");
    }
    public static void delete(String direPath){
        File file = new File(direPath);
        if (file.isFile()){
            return;
        }
        String str;
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile())
                System.out.println(f.delete()?"删除" + f.getName():"删除失败");
            if (f.isDirectory()){
                delete(f.getPath());
                System.out.println(f.delete()?"删除" + f.getName():"删除失败");
            }
        }
    }
}
