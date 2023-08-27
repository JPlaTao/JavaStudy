package Day802;

import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double bonus = 0;

        System.out.println("请输入工人工龄");
        int workingAge = scanner.nextInt();
        System.out.println("请输入工人工资");
        int salary = scanner.nextInt();

        if (workingAge<=5)
            bonus = salary * 0.05;
        else if (workingAge > 5 && workingAge <= 10)
            bonus = salary * 0.1;
        else if (workingAge > 10)
            bonus = salary * 0.15;

        System.out.println("这位工人工资为：" + salary);
        System.out.println(" 这位工人工龄为：" +  workingAge);
        System.out.println( "这位工人奖金为：" + bonus);
    }
}
