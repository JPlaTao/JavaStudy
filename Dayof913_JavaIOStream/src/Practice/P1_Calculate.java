package Practice;

import java.io.*;

public class P1_Calculate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        e_output(arr,"D:\\#Exe_TestFolder\\intFileTest\\intFileTest.txt");
        System.out.println(e_input("D:\\#Exe_TestFolder\\intFileTest\\intFileTest.txt"));
    }

    private static void e_output(int[] arr,String path){
        File file = new File(path);
        if (file.isDirectory()){
            System.out.println("此路径不是文件");
            return;
        }
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try(FileOutputStream fos = new FileOutputStream(file)) {
            String str = "";
            for (int i = 0; i < arr.length; i++) {
                str += arr[i];
                if (i + 1 != arr.length){
                    str += " ";
                }
            }
            fos.write(str.getBytes());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int e_input(String path){
        int sum = 0;
        try(FileInputStream fis = new FileInputStream(path)){
            String str = new String(fis.readAllBytes());
            String[] s = str.split(" ");
            for (int i = 0; i < s.length; i++) {
                if (s[i].isBlank())
                    continue;
                sum += Integer.parseInt(s[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sum;
    }
}
