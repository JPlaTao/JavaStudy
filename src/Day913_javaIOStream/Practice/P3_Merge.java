package Day913_javaIOStream.Practice;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Merge {
    public static void main(String[] args) {
        e_merge("D:\\#Exe_TestFolder\\fileSplit",
                "D:\\#Exe_TestFolder\\fileMerge\\mergedFile.zip");
    }
    private static void e_merge(String sourPath,String tarPath){
        File tarFile = new File(tarPath);
        if (tarFile.isDirectory()){
            System.out.println("此路径是目录");
            return;
        }
        if (!tarFile.getParentFile().exists()){
            tarFile.getParentFile().mkdirs();
        }
        File sourFile = new File(sourPath);
        File[] sourFiles = sourFile.listFiles();
        Arrays.sort(sourFiles, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int o1name = Integer.parseInt(o1.getName());
                int o2name = Integer.parseInt(o2.getName());
                return o1name - o2name;
            }
        });
        try(FileOutputStream fos = new FileOutputStream(tarFile,true)) {
            for (File sFile : sourFiles) {
                try(FileInputStream fis = new FileInputStream(sFile)){
                    fos.write(fis.readAllBytes());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}