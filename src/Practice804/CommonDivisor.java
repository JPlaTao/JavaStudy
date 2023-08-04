package Practice804;

import java.util.Scanner;

public class CommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个数");
        int num1 = scanner.nextInt();
        System.out.print("请输入第二个数");
        int num2 = scanner.nextInt();
        int bigNum = Math.max(num1, num2);
        int smallNum = Math.min(num1, num2);
        int commDivisor = 0;
        for (int i = 1; i < bigNum; i++) {
            if ( bigNum % i == 0 && smallNum % i == 0) {
                if ( i > commDivisor )
                    commDivisor = i;
            }
        }
        System.out.println("最大公约数为："+commDivisor);

        for (int i = bigNum; i > 0; i++) {
            if ( i % num1 == 0 && i% num2 ==0){
                System.out.println("最小公倍数为：" + i);
                break;
            }
        }
    }
}
