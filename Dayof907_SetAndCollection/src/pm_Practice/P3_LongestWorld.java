package pm_Practice;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class P3_LongestWorld {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet<>();
        hashSet.add("bird");
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("orio");
        hashSet.add("monkey");
        hashSet.add("basketball");

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String) o1;
                String s2 = (String) o2;
                return s1.length() - s2.length();
            }
        };
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.addAll(hashSet);
        System.out.println("最短：");
        System.out.println(treeSet.first());
        System.out.println("最长：");
        System.out.println(treeSet.last());
    }
}
