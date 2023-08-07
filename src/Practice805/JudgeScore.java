package Practice805;

import java.util.Scanner;

public class JudgeScore {
    public static void main(String[] args) {
        double[] scores = new double[6];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.print("请输入第一位评委的评分：");
            scores[i] = scanner.nextDouble();
        }
        double sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += scores[i];
        }
        System.out.println("选手成绩为：" + sum/scores.length);
    }
}
