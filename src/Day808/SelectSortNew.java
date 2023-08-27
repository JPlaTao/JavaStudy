package Day808;

public class SelectSortNew {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2,46, 4, 19, 50, 48};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
//            int temp = arr[i];
//            arr[i] = arr[minIndex];
//            arr[minIndex] = temp;

            arr[i] = arr[i] + arr[minIndex];
            arr[minIndex] = arr[i] - arr[minIndex];
            arr[i] = arr[i] - arr[minIndex];

//            arr[i] =arr[i] ^ arr[minIndex];
//            arr[minIndex] =arr[i] ^ arr[minIndex];
//            arr[i] = arr[i] ^ arr[minIndex];
        }
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
