package Test;

public class PrimeNumSumNewTest {
    public static void main(String[] args) {
        int sum = 0;
        otter:for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= i; j++) {
                if (i%j==0 & j!=i){
                    continue otter;//使用了continue，相较于break少用一个flag标识变量
                }
            }
            sum += i;
            System.out.println(i + "是素数");
        }
        System.out.println("它们的和为：" + sum);
    }
}
