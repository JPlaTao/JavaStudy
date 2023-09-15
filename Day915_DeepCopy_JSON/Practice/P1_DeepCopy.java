package Day915_DeepCopy_JSON.Practice;

import Day815_Object_QuickSort.Object;
import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

public class P1_DeepCopy {
    public static void main(String[] args) {
        Person person = new Person("老张","100",
                new Person("小张","101",null));
        File file = new File("D:\\4.WorkSpace\\JAVA\\java-study\\src\\Day915_DeepCopy_JSON\\Practice\\testFile_ObjStream");

//        e_DeepCopyBySerialize(p1,file);
        e_DeepCopyByJSON(person,file);
    }
    private static void e_DeepCopyBySerialize(Person o,File file){
        System.out.println(o);
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
             ObjectInputStream ois = new ObjectInputStream(
                     new FileInputStream(file))
        ) {
            oos.writeObject(o);
            Person oCopy = (Person) ois.readObject();

            System.out.println(oCopy);
            System.out.println(o == oCopy);
            System.out.println(o.equals(oCopy));

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void e_DeepCopyByJSON(Person o,File file){
        String oString = JSON.toJSONString(o);
        System.out.println(oString);

        Person oCopy = JSON.parseObject(oString,Person.class);

        System.out.println(oCopy);
        System.out.println(o == oCopy);
        System.out.println(o.equals(oCopy));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person implements Cloneable,Serializable {

    private String name;
    private String no;
    private Person son;

    @Override
    public Object clone() {
        return null;
    }
}