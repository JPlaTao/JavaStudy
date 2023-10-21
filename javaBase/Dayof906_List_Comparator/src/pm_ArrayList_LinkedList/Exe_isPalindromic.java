package pm_ArrayList_LinkedList;

import java.util.LinkedList;

public class Exe_isPalindromic {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
//        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);
        System.out.println(isHuiWen(linkedList));
    }
    public static boolean isHuiWen(LinkedList linkedList){
        while (true){
            if (linkedList.size()<=1){
                return true;
            }
            if (!linkedList.removeFirst().equals(linkedList.removeLast())){
                return false;
            }
        }
    }
}
