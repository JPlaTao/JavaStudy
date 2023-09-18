package pm;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Exe_FileWriter {
    public static void main(String[] args){
//        e_read();
    }

    private static void e_read(){
        File file = new File("D:\\#Exe_TestFolder\\testFile.txt");
        try(FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr)) {
            String line = "";
            while ( (line = bf.readLine()) != null ){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void e_write(){
        File file = new File("D:\\#Exe_TestFolder\\testFile.txt");
        try( FileWriter fwt = new FileWriter(file,true);
             BufferedWriter bwt = new BufferedWriter(fwt)){
//            bwt.write("长风破浪会有时，直挂云帆济沧海");
//            bwt.newLine();
//            bwt.write("噫吁嚱，危乎高哉");
//            bwt.newLine();
//            bwt.write("蜀道之难，难于上青天");
//            bwt.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void e_OutputStreamWriter(){
        File file = new File("D:\\#Exe_TestFolder\\testFile.txt");
        try( FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter ows = new OutputStreamWriter(fos, StandardCharsets.UTF_8)){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}