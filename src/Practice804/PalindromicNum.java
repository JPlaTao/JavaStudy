package Practice804;

import java.util.Scanner;

public class PalindromicNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个四位数");
        int num = scanner.nextInt();
        int frs = num / 1000;
        int sec = num / 100 % 10;
        int srd = num / 10 % 10;
        int frt = num % 10;
        if ( frs == frt )
        {
            if (sec == srd)
            {
                System.out.println("此数是回文数");
            }
        }
        else System.out.println("此数不是回文数");
    }
}
