package Practice805;

import java.util.Scanner;

public class ArrayFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个数字");
        int N = scanner.nextInt();
        int[] fibo = new int[N];
        switch (N) {
            case 1 -> {
                fibo[0] = 1;
                System.out.println(fibo[0]);}
            case 2 -> {
                fibo[0] = 1;
                fibo[1] = 1;
                System.out.println(fibo[0]);
                System.out.println(fibo[1]);}
            default -> {
                fibo[0] = 1;
                fibo[1] = 1;
                System.out.println(fibo[0]);
                System.out.println(fibo[1]);
                for (int i = 2; i < N; i++) {
                    fibo[i] = fibo[i - 2] + fibo[i - 1];
                    System.out.println(fibo[i]);
                }
            }
        }

    }
}
