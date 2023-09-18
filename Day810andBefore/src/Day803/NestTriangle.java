package Day803;

import java.util.Scanner;

public class NestTriangle {//git test
    public static void main(String[] args) {
        System.out.println("请输入三角形的行高");
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        for (int i = 0; i <= height; i++)
        {
            for (int j = 0;j < height - i; j++ ){
                System.out.print(" ");
            }
            for (int j = 1; j<= 2*i-1; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}