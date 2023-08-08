package Practice807;

import java.util.Random;

public class Revers {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = arr[i] ^ arr[arr.length - 1 -i];
            arr[arr.length - 1 - i] = arr[i] ^ arr[arr.length - 1 -i];
            arr[i] = arr[i] ^ arr[arr.length - 1 - i];
        }
        for (int i: arr
             ) {
            System.out.print(i + " ");
        }
    }
}
