

import java.util.Scanner;

public class LoopTree {//git test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入大小");
        int H = scanner.nextInt();
        for (int i = 1; i <= H - 2 ; i++)//第一个三角形
        {
            for (int j = 1; j <= H - i; j++){//输出空格
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {//输出*
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = H - 3; i <= H -1 ; i++)//第一个三角形
        {
            for (int j = 1; j <= H - i; j++){//输出空格
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {//输出*
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = H - 2 ; i <= H ; i++)//第一个三角形
        {
            for (int j = 1; j <= H - i; j++){//输出空格
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {//输出*
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < H * 0.5; i++) {
            for (int j = 0; j < H * 0.5; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < H - 2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
