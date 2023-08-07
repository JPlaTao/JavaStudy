package Practice805;

import java.util.Random;

public class RandomSum {
    public static void main(String[] args) {
        int[] randomNums= new int[6];
        Random random = new Random();
        int sum= 0;
        for (int i:randomNums
             ) {
            i =random.nextInt(100);
            System.out.println(i);
            sum += i;
        }
        System.out.println(sum);
    }
}
