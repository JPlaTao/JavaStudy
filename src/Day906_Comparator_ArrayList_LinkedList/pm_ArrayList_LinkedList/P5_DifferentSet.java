package Day906_Comparator_ArrayList_LinkedList.pm_ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Random;

public class P5_DifferentSet {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        fill(list1,10);
        fill(list2,5);

        System.out.println("list1 : ");
        list1.forEach( o -> System.out.print(o + "  "));
        System.out.println();
        System.out.println("list2 : ");
        list2.forEach( o -> System.out.print(o + "  "));
        System.out.println();
        System.out.println("differentSet : ");
        System.out.println(differentSet(list1, list2));

    }
    public static ArrayList differentSet(ArrayList list1, ArrayList list2){
        ArrayList temp = list1;
        temp.removeAll(list2);
        return distinct(temp);
    }

    private static void fill(ArrayList list, int length){
        Random random = new Random();
        for (int i = 0; i <length ; i++) {
            list.add(random.nextInt(10));
        }
    }

    private static ArrayList distinct(ArrayList list){
        ArrayList temp = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!temp.contains(list.get(i))){
                temp.add(list.get(i));
            }
        }
        return temp;
    }
}
