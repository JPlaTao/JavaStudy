package Day906_Comparator_ArrayList_LinkedList.pm_ArrayList_LinkedList;

import java.util.Iterator;
import java.util.Vector;

public class Exe_Remove {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add("7^$%");
        vector.add("1#&");
        vector.add("5343");
        vector.add("2$");
        vector.add("1#^$");
        vector.add("ad#fe1&");

        Iterator iterator = vector.iterator();
        while (iterator.hasNext()){
            String str =(String) iterator.next();
            if (str.contains("$")) {
                iterator.remove();
            }
        }

        vector.forEach( o -> System.out.println(o));
    }
}
