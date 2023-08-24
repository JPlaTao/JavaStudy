package Practice824;

import java.util.Scanner;

public class P4ValidBracket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = scanner.nextLine();
        System.out.printf("此字符串%s", isValid(str) ? "是" : "不是");
    }

    public static boolean isValid(String str) {
        if (str.isBlank())
            return true;
        str = str.replaceAll("\\s","");
        while (str.contains("()")){
            str = str.replace("()","");
        }
        return str.isEmpty();
    }
}
