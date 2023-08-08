package Practice807;

import java.util.Random;

public class BothOdd {
    public static void main(String[] args) {
        int[] randomNums = new int[50];
        Random random = new Random();
        for (int i = 0; i < randomNums.length; i++) {
            randomNums[i] = random.nextInt(100);
        }
        for (int i = 0; i < randomNums.length; i++) {
            if (i % 2 != 0 && randomNums[i] % 2 != 0) {
                System.out.println(randomNums[i] + ", "+ i);
            }
        }
    }
}
