import java.util.Scanner;
public class NarcNumber {
    public static void main(String[] args) {
        System.out.println("请输入一个三位整数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int hundred = num / 100;
        int ten = num / 10 % 10;
        int one = num % 10;
        boolean flag = (hundred * hundred * hundred) + (ten * ten * ten) + (one * one * one) == num;
        System.out.println(hundred);
        System.out.println(ten);
        System.out.println(one);
        System.out.println("判断此数" + num+"是否为水仙花数："+flag);
        scanner.close();
    }
}
