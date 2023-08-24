package Practice824;

import java.util.Scanner;

public class P3Distinct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String str = scanner.next();
        System.out.printf("去重后的字符串为：%s",distinct(str));
    }

    public static String distinct(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            for (int j = stringBuilder.length() - 1; j > i; j--) {
                if (stringBuilder.charAt(i) == stringBuilder.charAt(j)) {
                    stringBuilder.deleteCharAt(j);
                }
            }
        }
        return stringBuilder.toString();
    }

}
