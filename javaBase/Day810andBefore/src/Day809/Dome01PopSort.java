package Day809;

public class Dome01PopSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 6, 7, 3, 4, 9, 2};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                    arr[j] = arr[j + 1] ^ arr[j];
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
