package Practice808;

public class InsertSortMy {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 4, 2};


        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j >= 0 ; j--) {
                if (arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
