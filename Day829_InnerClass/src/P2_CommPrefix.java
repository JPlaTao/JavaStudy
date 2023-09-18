public class P2_CommPrefix {

    public static void main(String[] args) {
        String[] s = new String[]{"apple", "appetite", "applicable"};
        System.out.println(commPrefix(s));
    }

    public static String commPrefix(String[] s) {
        String commPrefix = "";
        int minLength = s[0].length();
        int minIndex = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() < minLength) {
                minIndex = i;
                minLength = s[i].length();
            }
        }
        for (int i = 0; i < minLength; i++) {
            char c = s[minIndex].charAt(i);
            int j = 0;
            while (j < s.length && s[j].charAt(i) == c ){
                j++;
            }
            if (j == s.length) {
                commPrefix += c;
            }
        }
        return commPrefix;
    }
}