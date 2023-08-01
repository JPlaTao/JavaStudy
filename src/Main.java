import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        FourDigitSum();
        NarcNumber();
        IsTriangle();
        ExchangeTemp();
        ExchangeXor();
    }

    public static void FourDigitSum()
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
    public static void NarcNumber() {
        System.out.println("请输入一个三位整数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int hundred = num / 100;
        int ten = num / 10 % 10;
        int one = num % 10;
        boolean flag = (hundred * hundred * hundred) + (ten * ten * ten) + (one * one * one) == num
                ? true:false;
        System.out.println(hundred);
        System.out.println(ten);
        System.out.println(one);
        System.out.println("判断此数" + num+"是否为水仙花数："+flag);
        scanner.close();
    }

    public static void IsTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个边长:");
        int sideLength1 = scanner.nextInt();
        System.out.print("请输入第二个边长:");
        int sideLength2 = scanner.nextInt();
        System.out.print("请输入第三个边长:");
        int sideLength3 = scanner.nextInt();
        boolean condition1 = sideLength1 + sideLength2 > sideLength3
                && sideLength1 + sideLength3 > sideLength2
                && sideLength2 + sideLength3 > sideLength1
                ? true : false;
        boolean condition2 = sideLength1 - sideLength2 < sideLength3
                && sideLength1 - sideLength3 < sideLength2
                && sideLength2 - sideLength3 < sideLength1
                ? true : false;
        boolean conditionFinal = condition1 & condition2 ? true : false;
        System.out.println("判断这三条边是否能够构成三角形：" + conditionFinal);
    }

    public static void ExchangeTemp() {
        int a = 10;
        int b = 20;
        int temp;
        temp = a;
        a = b;
        b = temp;
    }


    public static void ExchangeXor() {
        int a = 10;
        int b = 20;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
