package Practice804;

import java.util.Scanner;

public class FactorialN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数，计算其阶乘");
        int num = scanner.nextInt();
        int factorial = 1;
        for (int i = 1; i <= num ; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
    }
}
