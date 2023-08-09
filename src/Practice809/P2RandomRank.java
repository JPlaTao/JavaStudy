package Practice809;

import java.util.Random;

public class P2RandomRank {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        for (int i : arr) {
            System.out.print(i+ " ");
        }
    }
}
