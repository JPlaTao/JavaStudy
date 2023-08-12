package Test;

public class InsertSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 1, 8, 4, 2};
        for (int i = 1; i < arr.length; i++) {
            int currNum = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index]>currNum) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = currNum;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
