package Day915_DeepCopy_JSON.Practice;

import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class P2_ObjectAndJSONTransfer {
    public static void main(String[] args) {
        Game sekiro = new Game("sekiro",10,140000,268.0);
        String sekiroString = JSON.toJSONString(sekiro);
        File file = new File("D:\\4.WorkSpace\\JAVA\\java-study\\src\\Day915_DeepCopy_JSON\\Practice\\testFile.txt");
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(sekiroString);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Game {
    private String name;
    private double star;
    private int size;
    private double money;
}
