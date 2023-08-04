package Practice804;

import java.util.Scanner;

public class HollowTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入三角形的边长");
        int H = scanner.nextInt();
        for (int i = 0; i < H-1; i++) {
            for (int j = 0; j < H - i-1 ;j++){
                System.out.print("  ");
            }
            System.out.print("* ");
            for (int j = 0; j < 2 * i -1; j++) {
                System.out.print("  ");
            }
            if (i == 0) {
                System.out.print("");
            } else {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < 2 * H - 1; i++) {
            System.out.print("* ");
        }
    }
}
