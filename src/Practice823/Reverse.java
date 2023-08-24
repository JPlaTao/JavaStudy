package Practice823;

public class Reverse {

    public static void main(String[] args) {
        System.out.print(reverse("123456"));
    }
    public static String reverse(String str) {
        StringBuilder rev = new StringBuilder();
        for (int i = 0; i <= str.length() - 1; i++) {
            rev.append(str.charAt(str.length() - 1 - i));
        }
        return rev.toString();
    }
}
