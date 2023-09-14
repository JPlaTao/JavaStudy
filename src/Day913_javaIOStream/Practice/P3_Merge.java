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

    private static void e_merge(String sourPath, String tarPath) {
        File tarFile = new File(tarPath);
        if (tarFile.isDirectory()) {
            System.out.println("此路径是目录");
            return;
        }
        if (!tarFile.getParentFile().exists()) {
            tarFile.getParentFile().mkdirs();
        }
        File sourFile = new File(sourPath);
        File[] sourFiles = sourFile.listFiles();

//        //如果文件名按数字排序
//        Arrays.sort(sourFiles, new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                int o1name = Integer.parseInt(o1.getName());
//                int o2name = Integer.parseInt(o2.getName());
//                return o1name - o2name;
//            }
//        });
        try (FileOutputStream fos = new FileOutputStream(tarFile, true)) {
            for (File sFile : sourFiles) {
                try (FileInputStream fis = new FileInputStream(sFile)) {
                    try {
                        fos.write(fis.readAllBytes());
                    }catch (OutOfMemoryError e){
                        byte[] readBytes = new byte[Integer.MAX_VALUE - 8];
                        int size = 0;
                        while ((size = fis.read(readBytes)) != -1) {
                            fos.write(readBytes,0,size);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}