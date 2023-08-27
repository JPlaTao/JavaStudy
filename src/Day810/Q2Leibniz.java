package Day810;

import java.util.Scanner;

public class Q2Leibniz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入莱布尼茨级数:");
        int leibnizLevel = scanner.nextInt();
        System.out.println(leibniz(leibnizLevel));
    }

    public static double leibniz(int level) {
        double pi = 0;
        double levels = 0;
        for (double i = 1; i <= level; i++) {
            if (i % 2 == 1) {
                levels += 1 / (2 * i - 1);
            } else {
                levels -= 1 / (2 * i - 1);
            }
        }
        pi = 4 * levels;
        return pi;
    }

}
