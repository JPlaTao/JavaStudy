package Day807;

import java.util.Random;

public class OddLeftEvenRight {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
        int[] newArr = new int[arr.length];
        int oddCount = 0;
        int evenCount = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0){
                newArr[oddCount] = arr[i];
                oddCount++;
            }
            else {
                newArr[arr.length-evenCount] = arr[i];
                evenCount++;
            }
        }
        for (int i:newArr
             ) {
            System.out.print(i+" ");
        }
    }
}
