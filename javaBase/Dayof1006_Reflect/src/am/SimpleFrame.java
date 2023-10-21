package am;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class SimpleFrame {
    static void use(Object obj) throws IllegalAccessException, IOException {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        File file = new File("output.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(obj.getClass().getName() + "\n");
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            fileWriter.write(declaredField.getName() + " ==> " + declaredField.get(obj) + "\n");
            fileWriter.flush();
            System.out.println(declaredField.getName() +
                    "==>" +
                    declaredField.get(obj));
        }
        fileWriter.close();
    }
}
