package Practice808;

import java.util.Random;
import java.util.Scanner;

public class Q1ClassRank {
    public static void main(String[] args) {

        int[] arr = new int[5];//初始化一个数组
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {//给数组赋随机值
            arr[i] = random.nextInt(101);
        }
//        //for copy
//        int[] arr = new int[5];//初始化一个数组
//        Random random = new Random();
//        for (int i = 0; i < arr.length; i++) {//给数组赋随机值
//            arr[i] = random.nextInt(101);
//        System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入一个十以内的整数值:");
//        int n = scanner.nextInt();


        for (int i = 1; i < arr.length; i++) {
            int currentNum = arr[i];
            int index = i - 1;
            while (index >= 0 && currentNum > arr[index]) {
                arr[index+1] =arr[index];
                index--;
            }
            arr[index +1] = currentNum;
        }
        System.out.println("排名\t成绩");
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + "\t" + arr[i]);
        }
    }
}
