package Day906_Comparator_ArrayList_LinkedList.pm_ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Random;

public class P4_Intersection {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        for (int i = 0; i <10 ; i++) {
            list1.add(random.nextInt(10));
            list2.add(random.nextInt(10));
        }
        System.out.println("list1 : ");
        list1.forEach( o -> System.out.print(o + "  "));
        System.out.println();
        System.out.println("list2 : ");
        list2.forEach( o -> System.out.print(o + "  "));
        System.out.println();
        System.out.println("intersection : ");
        System.out.println(intersection(list1, list2));
    }

    public static ArrayList intersection(ArrayList list1, ArrayList list2) {
        if (list1 == list2)
            return list1;
        ArrayList temp = new ArrayList();
        ArrayList useSize = list1.size() > list2.size() ? list1 : list2;
        for (int i = 0; i < useSize.size(); i++) {
            if (list1.contains(useSize.get(i)) && list2.contains(useSize.get(i))
            && !temp.contains(useSize.get(i))){
                temp.add(useSize.get(i));
            }
        }
        return temp;
    }
}
