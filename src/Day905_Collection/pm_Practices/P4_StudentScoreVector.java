package Day905_Collection.pm_Practices;

import java.util.Iterator;
import java.util.Vector;

class StudentScoreVector {
    static Vector scores = new Vector();

    public static void main(String[] args) {
        scores.add(69);
        scores.add(42);
        scores.add(91);
        scores.add(71);
        scores.add(83);
        scores.add(89);
        scores.add(41);
        scores.add(75);
        scores.add(35);
        scores.add(26);

        System.out.println(scoreSection(60, 100));

    }

    public static int scoreSection(int left, int right) {
        Iterator iterator = scores.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            int temp = (int) iterator.next();
            if (temp >= left && temp < right) {
                count++;
            }
        }
        return count;
    }

}
