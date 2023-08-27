package Day811_Methods;

import java.util.Random;
import java.util.Scanner;

public class P1TreeGame {

    static int grow = 11;
    static int keep = 0;
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入操作次数");
        int times = scanner.nextInt();
        int last = -1;
        for (int i = 0; i < times; i++) {
            int type = random.nextInt(4);
            System.out.print("执行第"+(i+1)+"次\t");
            switch (type) {
                case 0 -> water();
                case 1 -> cut();
                case 2 -> fertilize();
                case 3 -> worms();
            }
            last = type;
            if (last != 3) {
                keep = 0;
            }
            if (grow <= 0) {
                System.out.println("成长值归零! 树死亡");
                break;
            }
        }
    }

    public static void water() {
        grow += 10;
        System.out.println("浇水 \t成长值+10\t 当前成长值:" + grow);
    }

    public static void cut() {
        grow += 5;
        System.out.println("修剪~\t成长值+5 \t 当前成长值:" + grow);
    }

    public static void fertilize() {
        grow += 20;
        System.out.println("打药!\t成长值+20\t当前成长值:" + grow);
    }

    public static void worms() {
        keep++;

        grow -= 10;
        System.out.println("生虫了!\t成长值-10\t当前成长值:" + grow);

        if (keep % 3 == 0) {
            grow -= 20;
            System.out.println("连续三次生虫! \t成长值额外-20 \t当前成长值:" + grow);
        }
    }

}
