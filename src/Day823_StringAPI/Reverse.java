package Day823_StringAPI;

public class Reverse {

    public static void main(String[] args) {
//        System.out.print(reverse("123456"));
        System.out.println(jieCheng(5));
    }

    public static String reverse(String str) {
        StringBuilder rev = new StringBuilder();
        for (int i = 0; i <= str.length() - 1; i++) {
            rev.append(str.charAt(str.length() - 1 - i));
        }
        return rev.toString();
    }

    /**
     * 递归阶乘
     * @param n 阶乘数
     * @return 递归
     */
    public static int jieCheng(int n) {
        if (n == 1) return 1;
        return n * jieCheng(n - 1);
    }
}
