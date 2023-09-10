package Exam05_0909;

import java.util.Scanner;
public class Q1_ManyWords{
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入字符串");
//        String s = scanner.nextLine();


//        //测试用例 1
//        String s = "the sky is blue";

//        //测试用例 2
//        String s = "  hello world  ";

        //测试用例 3
        String s = "a good   example";

        System.out.println(reverseWorlds(s));
    }
    public static String reverseWorlds(String s){
        //去除两端空格
        s = s.trim();
        //以空格分割字符串
        String[] split = s.split(" ");
        //StringBuilder 用来建立返回字符串
        StringBuilder sb = new StringBuilder();

        //去除每个单词两端的空格(突然发现没必要)
//        for (int i = 0; i < split.length; i++) {
//            split[i] = split[i].trim();
//        }
        //遍历单词数组
        for (int i = split.length -1;i >= 0; i--){
            //如果此单词为空，则跳过它
            if ((split[i].isBlank())){
                continue;
            }
            //否则将其加在StringBuilder后
            sb.append(split[i]);
            //如果此单词不是最后一个，则在其后加空格
            if (!(i - 1 < 0)){
                sb.append(" ");
            }
        }
        //返回结果字符串
        return sb.toString();
    }
}
