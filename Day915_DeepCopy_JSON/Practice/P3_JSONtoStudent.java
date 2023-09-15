package Day915_DeepCopy_JSON.Practice;

import com.alibaba.fastjson2.JSON;
import lombok.Data;

import java.io.*;
import java.util.Arrays;

public class P3_JSONtoStudent {
    public static void main(String[] args) {
        File file = new File("D:\\4.WorkSpace\\JAVA\\java-study\\src\\Day915_DeepCopy_JSON\\Practice\\student.json");
        String obj = "";
        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader);
        ){
            while (bufferedReader.ready()){
                obj += bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Student fywy/*枫原万叶*/ = JSON.parseObject(obj, Student.class);
        System.out.println(fywy);
    }
}
@Data
class Student {
    private int id;
    private String name;
    private int age;
    private String password;
    private String[] hobby;
}


