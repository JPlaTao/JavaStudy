package Day810;

public class Q4PerfectNum {
    public static void main(String[] args) {
        for (long i = 1; true; i++) {
            long factors = 0;
            for (long j = 1; j < i; j++) {
                if (i % j == 0) {
                    factors += j;
                }
            }
            if (i == factors) {
                System.out.println(i);
            }
        }
    }
}
