package Day824_StringClassPractice;

import java.util.Scanner;

public class P2_ValidBracket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = scanner.nextLine();
        System.out.println("此字符串"+( isValid(str) ? "是" : "不是") + "正确的括号字串");
    }

    public static boolean isValid(String str) {
        if (str.isBlank())
            return true;
        str = str.replaceAll(" ","");
        while (str.contains("()")||str.contains("[]")||str.contains("{}")){
            str = str.replace("()","");
            str = str.replace("[]","");
            str = str.replace("{}","");
        }
        return str.isEmpty();
    }
}
