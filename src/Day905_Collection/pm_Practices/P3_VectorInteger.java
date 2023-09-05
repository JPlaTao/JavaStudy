package Day905_Collection.pm_Practices;

import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;

class VectorInteger {
    static Vector vector = new Vector();

    public static void main(String[] args) {
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(22);
        vector.add(2);
        System.out.println(count(2));
    }

    public static int count(int num){
        Iterator iterator = vector.iterator();
        int count = 0;
        while (iterator.hasNext()){
            if (Objects.equals(num,iterator.next())){
                count++;
            }
        }
        return count;
    }
}
