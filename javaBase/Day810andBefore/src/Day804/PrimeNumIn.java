package Day804;

import java.util.Scanner;

public class PrimeNumIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入范围");
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i ++){
            boolean flag = true;
            for (int j = 2 ; j <= i;j ++){
                if( i % j == 0 & j !=i)//判断此数不是素数
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println( i + "是素数");
        }
    }
}
