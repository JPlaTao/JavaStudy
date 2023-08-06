package Test;

import java.util.Scanner;

public class Fibona7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个数");
        int n = scanner.nextInt();
        int num1 = 0;
        int num2 = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            num1 = num2;
            num2 = sum;
            sum = num1 + num2;
            System.out.println(sum);
        }
    }
}
