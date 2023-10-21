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

    public static int longestSubSeq(String str1, String str2) {
        int n = str1.length() + 1;
        int m = str2.length() + 1;
        int[][] arr = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
            }
        }


        return arr[str1.length()][str2.length()];
    }

    public static String longestSubSeq0(String str1, String str2) {
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
