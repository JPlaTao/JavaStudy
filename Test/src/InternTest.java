public class InternTest {
    public static void main(String[] args) {
        String a ="a";
        String s = new String("bc"+a);
        String s1 = s.intern();
        String str = "abc";
        System.out.println(str == s);
        System.out.println(str == s1);
        System.out.println(s == s1);
    }
}
