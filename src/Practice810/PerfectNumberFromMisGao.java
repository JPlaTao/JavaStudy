package Practice810;

public class PerfectNumberFromMisGao {
    public static void main(String[] args) {
        // 编写一个Java程序，使用循环输出所有的完美数。
        // 完美数是等于其所有因子之和的正整数，如 6 = 1 + 2 + 3。
//        perfectNumber(100000000);
        perfectNumber();
    }

    public static void perfectNumber(int number) {

        for (int i = 1; i < number; i++) {
            int sum = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.println(sum);
            }
        }
    }

    // 优化算法
    public static void perfectNumber() {
        int count = 0;
        for (long i = 2; i < (long) (Math.pow(10, 60)); i += 2) { // 完美数都是偶数
            long sum = 0;
            for (long j = 1; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sum += j;
                    sum += i / j;
                }
            }
            sum -= i;
            if (sum == i) {
                System.out.println(i);
            } else if (i % 1000000 == 0) {
                System.out.println((++count) + "millions");
            }
        }
    }
}
