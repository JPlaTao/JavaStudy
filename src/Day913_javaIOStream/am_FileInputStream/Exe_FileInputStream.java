package Day913_javaIOStream.am_FileInputStream;

import java.io.*;

public class Exe_FileInputStream {
    public static void main(String[] args) {
        String path1 = "D:\\#Exe_TestFolder\\testFile.txt";
        Exe_fileInStream(path1);
    }


    private static void Exe_fileInStream(String pathName) {
        Exe_fileInStream1(pathName,10);
        Exe_fileInStream2(pathName);
    }

    private static void Exe_fileInStream1(String pathName,int len) {
        File testFile = new File(pathName);
        try (FileInputStream fileInputStream = new FileInputStream(testFile)) {
            //定义一个byte[]数组用来接收read()到的结果，将其循环加到结果字符串"result"中
            //size变量用来控制while循环，表示的是每次从流中获取到几个字节
            int size = 0;
            //readBytes 用来接收read()结果，每次 len 个
            byte[] readBytes = new byte[len];
            //result字符串，输出结果
            String result = "";
            //当size为-1，也就是从流中获取字节失败，也就是流中已经没有字节了，循环停止。
            while (size != -1) {
                //将获取到的byte数组转成字符串加到结果字符串中。
                result += new String(readBytes, 0, size);
                //改变循环变量
                size = fileInputStream.read(readBytes);
            }
            System.out.println(result);
            //此方法相对复杂，但可靠性较高

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void Exe_fileInStream2(String pathName){
        File testFile = new File(pathName);
        try(FileInputStream fileInputStream = new FileInputStream(testFile)) {
            //readNums表示从流中获取到的字节个数
            int readNums;
            //availableNums表示流中可获取到的字节个数
            int availableNums = fileInputStream.available();
            //bytes 数组用来接收流中的字节，长度是可用字节总数
            byte[] bytes = new byte[availableNums];
            //read()流，将结果给到数组，将字符的个数给到readNums
            readNums = fileInputStream.read(bytes);
            //输出
            System.out.println("read " + readNums + " bits");
            System.out.println(new String(bytes));
            //此方法比较简单，但比较费内存，而且如果文件较大会出现内存溢出的问题
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
