package Day907_HashSet_TreeSet_Collection.pm_Practice;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.TreeSet;

class FindDate {
    public static void main(String[] args) {
        HashSet dates = new HashSet<>();

        dates.add(LocalDate.now());
        dates.add(LocalDate.of(2002,9,28));
        dates.add(LocalDate.of(1999,6,20));
        dates.add(LocalDate.of(2001,5,26));
        dates.add(LocalDate.of(2001,5,25));
        dates.add(LocalDate.of(2002,4,27));

        TreeSet treeSet = new TreeSet<>();
        treeSet.addAll(dates);
        treeSet.forEach(o -> System.out.println(o));
        System.out.println("最早：");
        System.out.println(treeSet.first());
        System.out.println("最晚：");
        System.out.println(treeSet.last());
    }
}
