import java.util.Scanner;

public class StringLearning {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        String str;
//        System.out.println("请输入email");
//        String email = scanner.next();
        String str = "Java语言是面向对象的，" +
                "Java语言是健壮的，" +
                "Java语言是安全的，" +
                "Java是高性能的，" +
                "Java语言是跨平台的";
//        System.out.println(countTarget(str,"Java"));
        count();


    }


    public static void count() {
        System.out.println("请输入一个字符串");
        String string = scanner.next();
        byte[] asciis = string.getBytes();
//        System.out.println(Arrays.toString(asciis));
        int cntLetter = 0;
        int cntNum = 0;
        for (byte ascii : asciis) {
            if (ascii >= 65 && ascii <= 90 || ascii >= 97 && ascii <= 122) {
                cntLetter++;
            } else if (ascii >= 48 && ascii <= 57) {
                cntNum++;
            }
        }
        System.out.printf("数字有%d个，字母有%d个。", cntNum, cntLetter);
    }


    public static int countTarget(String string, String target) {
        int cnt = 0;
        int index = string.indexOf(target);
        while (string.contains(target)) {
            string = string.substring(index + target.length());
            index = string.indexOf(target);
            cnt++;
        }
        return cnt;
    }


    public static boolean isLegal(String email) {
        return email.contains("@") && email.contains(".")
                && email.indexOf("@") > email.indexOf(".")
                && email.indexOf("@") == email.lastIndexOf("@")
                && !email.startsWith("@") && !email.endsWith(".");
    }
}
