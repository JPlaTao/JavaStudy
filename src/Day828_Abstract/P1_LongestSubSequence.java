package Day828_Abstract;

import java.util.Scanner;

public class P1_LongestSubSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个字符串");
        String str1 = scanner.nextLine();
        System.out.println("请输入第二个字符串");
        String str2 = scanner.nextLine();
        System.out.println("他们的最长公共子序列为：" + longestSubSeq(str1, str2));
    }

    public static String longestSubSeq(String str1, String str2) {
        String str = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (str.indexOf(str1.charAt(i)) != -1) break;
                    str += str1.charAt(i);
                    break;
                }
            }
        }
        return str;
    }
}
