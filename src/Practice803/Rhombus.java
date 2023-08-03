package Practice803;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {

        System.out.println("请输入菱形的边长");
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
        //下半部分三角形
        for (int i = 1; i <= height-1; i++)
        {
            for ( int j = 1; j <= i ; j++ ){
                System.out.print(" ");
            }
            for ( int j = 1;j <= 2*(height - i)-1; j++ ){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
