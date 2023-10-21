package Day807;

public class ArrayPractice {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] newArr = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                newArr[i] = arr[i] * arr[i + 1];
            } else if (i != 9) {
                newArr[i] = arr[i - 1] * arr[i] * arr[i + 1];
            } else {
                newArr[i] = arr[i - 1] * arr[i];
            }
            System.out.println(newArr[i]);
        }
    }
}
