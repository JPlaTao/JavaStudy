package Practice802;

import java.util.Scanner;
public class Calculator {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入第一个数");
                double num1 = scanner.nextDouble();
                System.out.println("请输入第二个数");
                double num2 = scanner.nextDouble();
                System.out.println("请输入操作符");
                String opera = scanner.next();


                switch (opera) {
                        case "+" -> System.out.println(num1 + "+" + num2 + "=" + num1 + num2);
                        case "-" -> System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
                        case "*" -> System.out.println(num1 + "*" + num2 + "=" + num1 * num2);
                        case "/" -> System.out.println(num1 + "/" + num2 + "=" + num1 / num2);
                        case "%" -> System.out.println(num1 + "%" + num2 + "=" + num1 % num2);
                        default -> System.out.println("无效的运算符");

                }
        }
}