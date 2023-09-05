package Day905_Collection.pm_Practices;

import java.util.Vector;

public class P1_StudentName {
    static Vector stuNames = new Vector();

    public static void main(String[] args) {
        addName("oppenheimer");
        addName("wangWu");
        addName("lazySheepSheep");
        addName("doraAmon");
        showAll();
        removeName("oppenheimer");
        System.out.println();
        showAll();
    }

    public static void addName(String name){
        stuNames.add(name);
    }

    public static void removeName(String name){
        stuNames.remove(name);
    }

    public static void showAll(){
        stuNames.forEach((name)-> System.out.print(name + " "));
    }

}
