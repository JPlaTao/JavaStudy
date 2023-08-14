package Practice814_Array_QuickSort_PrimeFactor;

import java.util.Scanner;

public class PrimeFactor {
    public static void main(String[] args) {
        //输入一个数，输出它的质因数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        findFactors(n);
    }

    public static void findFactors(int n) {
        for (int i = 2; i <= n; i++)
            if (n % i == 0) {
                if (isPrime(i)) {
                    System.out.println(i);
                }
            }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 & i != n) return false;
        }
        return true;
    }
}
