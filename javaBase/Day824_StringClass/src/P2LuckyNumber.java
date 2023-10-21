import java.util.Arrays;
import java.util.Random;

public class P2LuckyNumber {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] arr = new int[20];
        randomDistinctNumber(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void randomDistinctNumber(int[] arr) {
        for (int i = 0; i < 20; i++) {
            arr[i] = random.nextInt(39) + 1;
            if (i!=0){
                int j = i - 1;
                while (j != 0 && arr[i] != arr[j]) {
                    j--;
                }
                if (arr[i] == arr[j]){
                    i--;
                }
            }
        }
    }
}
