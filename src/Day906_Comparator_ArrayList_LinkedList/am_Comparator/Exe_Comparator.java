package Day906_Comparator_ArrayList_LinkedList.am_Comparator;

import java.util.Comparator;
import java.util.Vector;

public class Exe_Comparator {

    public static void main(String[] args) {
        Vector vector = new Vector();

        vector.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int) o1 - (int) o2;
            }
        });
    }
}
