package Exam04;

import java.util.Random;
import java.util.Scanner;


public class PassWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入密码长度");
        int n = scanner.nextInt();
        System.out.println(randPassWorld(n));
    }

    public static String randPassWorld(int n) {
        Random random = new Random();
        String str = "";
        for (int i = 0; i < n; i++) {
            char c = 0;
            int type = random.nextInt(3);
            if (i == 0) type++;
            switch (type) {
                case 0 -> c = (char) (random.nextInt(10) + 48);
                case 1 -> c = (char) (random.nextInt(26) + 65);
                case 2 -> c = (char) (random.nextInt(26) + 97);
            }
            if (str.indexOf(c) >=0) i--;
            else str += c;
        }
        return str;
    }
}
