package Practice807;

import java.util.Random;
import java.util.Scanner;

public class Multiple {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("请输入第" + i + "/5个1-60之间的数：");
            arr[i] = scanner.nextInt();
        }
        Random random = new Random();
        int num = random.nextInt(8)+2;
        System.out.println("随机数为："+num);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%num != 0){
                System.out.println(arr[i]+"不是随机数的倍数");
            }
        }
    }
}
