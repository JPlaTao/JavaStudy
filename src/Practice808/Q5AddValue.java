package Practice808;

import java.util.Random;
import java.util.Scanner;

public class Q5AddValue {
    public static void main(String[] args) {

        int[] arr = new int[5];//初始化一个数组
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {//给数组赋随机值
            arr[i] = random.nextInt(101);
        System.out.print(arr[i] + " ");
        }
        System.out.println();


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入位置:");
        int n = scanner.nextInt();
        System.out.println("请输入值:");
        int k = scanner.nextInt();

        int[] arrNew = new int[arr.length+1];
        for (int i = 0,j = 0 ; i < arrNew.length; i++,j++) {
            if ((i+1) == n){
                arrNew[n-1] = k;
                i++;
            }
            arrNew[i] = arr[j];
        }
        for (int i : arrNew) {
            System.out.print(i + " ");
        }
    }
}
