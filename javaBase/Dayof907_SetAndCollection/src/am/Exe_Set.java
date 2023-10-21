package am;

import java.util.HashSet;
import java.util.Set;

public class Exe_Set {
    public static void main(String[] args) {
        Set set = Set.of(1,2,3,4,5);
        set.forEach(o -> System.out.print(o + " "));
        System.out.println();
        set.forEach(o -> System.out.print(o + " "));
        System.out.println();
        HashSet<Integer> integerHashSet = new HashSet<Integer>();
        integerHashSet.add(1);
        integerHashSet.add(2);
        integerHashSet.add(3);
        integerHashSet.add(4);
        integerHashSet.add(5);
        integerHashSet.forEach(o-> System.out.println(o));
    }
}
