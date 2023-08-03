package Practice803;

public class LoopTree {
    public static void main(String[] args) {
        int H = 5;
        for (int i = 1; i <= 3 ; i++)//第一个三角形
        {
            for (int j = 1; j <= H - i; j++){//输出空格
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {//输出*
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 2; i <= 4 ; i++)//第一个三角形
        {
            for (int j = 1; j <= H - i; j++){//输出空格
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {//输出*
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 3; i <= 5 ; i++)//第一个三角形
        {
            for (int j = 1; j <= H - i; j++){//输出空格
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {//输出*
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 3; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
