package Practice805;

import java.util.Random;
import java.util.Scanner;

public class CountNum {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个20~40之间的数");
        int num;
        while (true){
            num = scanner.nextInt();
            if (num<20 || num >40){
                System.out.println("输入错误，请重新输入");
            }else break;
        }
        int[] rdmNum = new int[20];
        int count = 0;
        for (int i = 0; i < rdmNum.length; i++) {
            rdmNum[i] = random.nextInt(20)+20;
            System.out.println(rdmNum[i]);
            if (num == rdmNum[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
