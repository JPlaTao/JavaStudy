import java.util.Scanner;

public class P1LongestSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个字符串:");
        String str = scanner.nextLine();
        System.out.println("此字符串最长不重复字串长度为：" + longestSubstring(str));
    }

    public static int longestSubstring(String str) {
        char[] chars = str.toCharArray();
        StringBuilder substrNoRep = new StringBuilder();
        int count = 0;
        for (int k = 0; k < chars.length - 1; k++) {
            substrNoRep.append(str.charAt(k));
            for (int i = k+1; i <= chars.length - 1; i++) {
                int j = substrNoRep.length()-1;
                while (j >= 0 && chars[i] != substrNoRep.charAt(j)) {
                    j--;
                }
                if (j >= 0) break;
                substrNoRep.append(chars[i]);
            }
            if (substrNoRep.length() > count) count = substrNoRep.length();
            substrNoRep.delete(0, substrNoRep.length());
        }
        return count;
    }
}
