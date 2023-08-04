package Practice804;

import java.util.Scanner;

public class SquareShape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入边长");
        int sideLength = scanner.nextInt();

        System.out.print("# ");//左上角 #
        for (int j = 0; j < sideLength - 2; j++) {//上边 @ @ @
            System.out.print("@ ");
        }
        System.out.print("# ");// 右上角 #


        System.out.println();//换行


        for (int i = 0; i < sideLength - 2; i++) {//中间内容
            System.out.print("@ ");
            for (int j = 0; j < sideLength - 2; j++) {
                System.out.print("* ");
            }
            System.out.print("@ ");
            System.out.println();
        }


        System.out.print("# ");
        for (int j = 0; j < sideLength - 2; j++) {
            System.out.print("@ ");
        }
        System.out.print("# ");
        System.out.println();
    }
}
