package Practice801;

import java.util.Scanner;
public class IsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个边长:");
        int sideLength1 = scanner.nextInt();
        System.out.print("请输入第二个边长:");
        int sideLength2 = scanner.nextInt();
        System.out.print("请输入第三个边长:");
        int sideLength3 = scanner.nextInt();
        boolean condition1 = sideLength1 + sideLength2 > sideLength3
                && sideLength1 + sideLength3 > sideLength2
                && sideLength2 + sideLength3 > sideLength1;
        boolean condition2 = sideLength1 - sideLength2 < sideLength3
                && sideLength1 - sideLength3 < sideLength2
                && sideLength2 - sideLength3 < sideLength1;
        boolean conditionFinal = condition1 & condition2;
        System.out.println("判断这三条边是否能够构成三角形：" + conditionFinal);
    }
}
