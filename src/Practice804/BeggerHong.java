package Practice804;

public class BeggerHong {
    public static void main(String[] args) {
        int sum = 0;
        int dayPay = 1;
        for (int i = 1; i < 10; i++) {
            dayPay *= 2;
            sum += dayPay;
        }
        System.out.println("BeggerHong 10天挣了" + sum + "块钱");
    }
}
