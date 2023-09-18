package Test;

public class PrimeNumSumNewTest {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i < 100; i++) {
//            System.out.print(i+"\t");
            if (isPrimeNum(i)) sum += i;
        }
        System.out.print(sum);
//        otter:for (int i = 2; i <= 100; i++) {
//            for (int j = 2; j <= i; j++) {
//                if (i%j==0 & j!=i){
//                    continue otter;//使用了continue，相较于break少用一个flag标识变量
//                }
//            }
//            sum += i;
//            System.out.println(i + "是素数");
//        }
//        System.out.println("它们的和为：" + sum);
    }
    public static boolean isPrimeNum(int i) {
        for (int j = 2; j <= i; j++) {
            if (i % j == 0 & i != j & j != 1) return false;
        }
        return true;
    }
}