package Practice802;

import java.util.Scanner;

public class Season {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个月份");
        int month = scanner.nextInt();
        String season = switch (month){
                        case 3,4,5 -> "春季";
                        case 6,7,8 -> "夏季";
                        case 9,10,11 -> "秋季";
                        case 12,1,2 -> "冬季";
                        default -> "输入错误";
        };
        if(season.equals("输入错误")) {
            System.out.println(season);
        }
        else {
            System.out.println("这个季节是：" + season);
        }
    }
}
