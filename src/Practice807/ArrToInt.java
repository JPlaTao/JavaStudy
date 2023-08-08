package Practice807;

import java.util.Random;
import java.util.Scanner;

public class ArrToInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入此数组长度：");
        int N = scanner.nextInt();
        int[] arr = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(9);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int num = 0;
        for (int j : arr) {
            num *= 10;
            num += j;
        }
        System.out.println(num);
    }
}
