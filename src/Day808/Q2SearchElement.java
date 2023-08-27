package Day808;

import java.util.Random;
import java.util.Scanner;

public class Q2SearchElement {
    public static void main(String[] args) {
        int[] arr = new int[10];

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个十以内的整数值:");
        int n = scanner.nextInt();

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {//给数组赋随机值
            arr[i] = random.nextInt(11);
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==n){
                System.out.print(i + " ");
                flag = false;
            }
        }
        System.out.println();
        if (flag) System.out.println(-1);
    }
}
