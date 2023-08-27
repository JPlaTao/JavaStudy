package Day823_StringAPI;

import java.util.Random;

public class VerifyCode {
    static Random random = new Random();

    public static void main(String[] args) {
//        char c = 69;
//        System.out.println(c);
        verificationCode();
    }

    public static void verificationCode() {
        int type = -1;
        char c = 0;
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            type = random.nextInt(3);
            switch (type) {
                case 0 -> {
                    c = (char) (random.nextInt(26) + 65);
                }
                case 1 -> {
                    c = (char) (random.nextInt(26) + 97);
                }
                case 2 -> {
                    c = (char) (random.nextInt(9) + 48);
                }
            }
            code.append(c);
        }
        System.out.print(code);
    }
}
