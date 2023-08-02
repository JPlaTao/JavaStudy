package Practice802;

import java.util.Scanner;

public class TranslateCF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择你要输入的温度单位(C/F)");
        String unit = scanner.next();
        System.out.println("请输入你要输入的温度");
        int temp = scanner.nextInt();

        switch (unit){
            case "C","c" -> System.out.println( "将其转为华氏度为：" + (temp*9/5) + 32 + "f" );
            case "F","f" -> System.out.println( "将其转为摄氏度为：" + (temp - 32) * 5 /9 + "c" );
        }
    }
}
