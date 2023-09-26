public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "ab";
        String d = "a" + "b";
        String e = a + "b";
        String f = "a" + b;
        System.out.println((c == d) + "\n" + (c == e)
                + "\n" + (c == f) + "\n" + (c ==f));
    }


}
