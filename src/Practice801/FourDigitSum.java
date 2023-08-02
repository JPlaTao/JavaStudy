package Practice801;

import java.util.Scanner;

public class FourDigitSum {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个四位整数");
        int num = scanner.nextInt();
        int thousand = num / 1000;
        int hundred = num / 100 % 10;
        int ten = num / 10 % 10;
        int one = num % 10 ;
        int sum = thousand + hundred + ten + one ;
        System.out.println("此四位数各位数之和为："+ sum);
    }
}
