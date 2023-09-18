package Day803;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNum = random.nextInt(100)+1;
        System.out.print("猜一个数:");

        while(true){
            int guessNum = scanner.nextInt();
            if (guessNum == randomNum)
            {
                System.out.println("恭喜你，猜中了");
                break;
            } else if (guessNum > randomNum) {
                System.out.println("你猜的大了，再猜一次吧");
            } else if (guessNum < randomNum) {
                System.out.println("你猜的小了，再猜一次吧");
            }
        }
    }
}
