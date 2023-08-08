package Practice807;

import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        int[] judge = new int[6];
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for (int i = 0; i < judge.length; i++) {
            System.out.println("第" + (i+1) + "位评委打分为：");
            judge[i] = scanner.nextInt();
            System.out.println(judge[i]);
            sum += judge[i];
        }
        int max = 0;
        for (int j : judge) {
            if (j > max) max = j;
        }
        System.out.println(max);
        int min = judge[0];
        for (int j : judge) {
            if (j<min) min = j;
        }
        System.out.println(min);
        sum = sum - max - min;
        System.out.println("最终得分为：" + sum/ (judge.length-2));
    }
}
