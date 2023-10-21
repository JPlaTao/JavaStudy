package Practice;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

class P2_Transfer {
    public static void main(String[] args) {
        e_byteStream();
        e_charStream();
    }
    private static void e_charStream(){
        File chuShiBiao = new File("D:\\#Exe_TestFolder\\ChuShiBiao\\chuShiBiao.txt");
        File csbGBK = new File("D:\\#Exe_TestFolder\\ChuShiBiao\\chuShiBiaoGBK_ByChar.txt");
        try (FileReader fr = new FileReader(chuShiBiao);
             FileWriter fw = new FileWriter(csbGBK, Charset.forName("GBK"))
        ){
            char[] buffer = new char[1024];
            int charRead;
            while ( (charRead = fr.read(buffer)) != -1 ){
                fw.write(buffer);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void e_byteStream(){
        File chuShiBiao = new File("D:\\#Exe_TestFolder\\ChuShiBiao\\chuShiBiao.txt");
        File csbGBK = new File("D:\\#Exe_TestFolder\\ChuShiBiao\\chuShiBiaoGBK_ByByte.txt");
        try (FileInputStream fis = new FileInputStream(chuShiBiao);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr);
             FileOutputStream fos = new FileOutputStream(csbGBK);
             OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
             BufferedWriter bw = new BufferedWriter(osw);
        ) {
            char[] buffer = new char[1024];
            int byteRead;
            while ( (byteRead = br.read(buffer)) != -1 ){
                bw.write(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
