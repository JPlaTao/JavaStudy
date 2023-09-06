package Day906_Comparator_ArrayList_LinkedList.pm_ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Random;

public class P3_Distinct {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }

        list.forEach( o -> System.out.print(o + " "));
        System.out.println();
        System.out.println(distinct(list));
    }

    public static int distinct(ArrayList list){
        ArrayList temp = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!temp.contains(list.get(i))){
                temp.add(list.get(i));
            }
        }
        return temp.size();
    }
}
