package Practice802;

import java.util.Scanner;

public class Constellation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份");
        int month = scanner.nextInt();
        System.out.println("请输入日期");
        int day = scanner.nextInt();

        String constellation = switch (month){
            case 1 -> {
                if (day >= 20 && day <= 31)
                    yield "水瓶座";
                else if (day > 0 && day <= 19)
                    yield "魔羯座";
                else yield  "日期输入错误";
            }


            case 2 -> {

                if (day >= 19 && day <= 29)
                {yield "双鱼座";}
                else if (day > 0 && day <= 18)
                {yield "水瓶座";}
                else yield  "日期输入错误";

            }
            case 3 -> {
                if (day >= 21 && day <= 31)
                    yield "白羊座";
                else if (day > 0 && day <= 20)
                    yield "双鱼座";
                else yield  "日期输入错误";

            }
            case 4 -> {
                if (day >= 19 && day <= 31)
                    yield "金牛座";
                else if (day > 0 && day <= 19)
                    yield "白羊座";
                else yield  "日期输入错误";

            }
            case 5 -> {
                if (day >= 20 && day <= 31)
                    yield "双子座";
                else if (day > 0 && day <= 21)
                    yield "金牛座";
                else yield  "日期输入错误";

            }
            case 6 -> {
                if (day >= 21 && day <= 31)
                    yield "巨蟹座";
                else if (day > 0 && day <= 20)
                    yield "双子座";
                else yield  "日期输入错误";

            }
            case 7 -> {
                if (day >= 23 && day <= 31)
                    yield "狮子座";
                else if (day > 0 && day <= 22)
                    yield "巨蟹座";
                else yield  "日期输入错误";

            }
            case 8 -> {
                if (day >= 23 && day <= 31)
                    yield "处女座";
                else if (day > 0 && day <= 22)
                    yield "狮子座";
                else yield  "日期输入错误";

            }
            case 9 -> {
                if (day >= 23 && day <= 31)
                    yield "天秤座";
                else if (day > 0 && day <= 20)
                    yield "处女座";
                else yield  "日期输入错误";

            }
            case 10 -> {
                if (day >= 22 && day <= 31)
                    yield "天蝎座";
                else if (day > 0 && day <= 23)
                    yield "天秤座";
                else yield  "日期输入错误";

            }
            case 11 -> {
                if (day >= 22 && day <= 31)
                    yield "射手座";
                else if (day > 0 && day <= 21)
                    yield "天蝎座";
                else yield  "日期输入错误";

            }
            case 12 -> {
                if (day >= 22 && day <= 31)
                    yield "摩羯座";
                else if (day > 0 && day <= 21)
                    yield "射手座";
                else yield  "日期输入错误";

            }
            default -> "月份输入错误";
        } ;

        if (constellation == "月份输入错误")
            System.out.println(constellation);
        else if (constellation == "日期输入错误")
            System.out.println(constellation);
            else
            System.out.println("该日期是：" + constellation);
    }
}
