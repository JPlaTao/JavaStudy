package Day802;

import java.util.Scanner;
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年份");
        int year = scanner.nextInt();
        System.out.println("请输入一个月份");
        int month = scanner.nextInt();

        int days = switch (month){
            case 1,3,5,7,8,10,12 ->  31;
            case 4,6,9,11 -> 30;
            case 2 -> {
                //判断是否为闰年
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    yield 29;
                } else
                    yield 28;
            }
            default -> -1;
        };
        System.out.println( days == -1? "输入的月份不正确" : "此月" + days + "天");
    }

    public void Calculator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数");
        double num1 = scanner.nextDouble();
        System.out.println("请输入第二个数");
        double num2 = scanner.nextDouble();
        System.out.println("请输入操作符");
        String opera = scanner.next();


        switch (opera){
            case "+" -> System.out.println(num1 + "+" + num2 + "=" + num1 + num2);
            case "-" -> System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
            case "*" -> System.out.println(num1 + "*" + num2 + "=" + num1 * num2);
            case "/" -> System.out.println(num1 + "/" + num2 + "=" + num1 / num2);
            case "%" -> System.out.println(num1 + "%" + num2 + "=" + num1 % num2);

        }
    }

}