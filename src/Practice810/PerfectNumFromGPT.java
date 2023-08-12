package Practice810;

public class PerfectNumFromGPT {
    public static void main(String[] args) {
        int start = 1;
        int end = 99999999;

        System.out.println("Perfect Numbers between " + start + " and " + end + ":");
        for (int i = start; i <= end; i++) {
            if (isPerfectNumber(i)) {
                System.out.println(i);
            }
            if (i % 10000000 == 0) {
                int mils = i / 10000000;
                System.out.println(mils + "million");
            }
        }
    }

    public static boolean isPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1; // 1 is always a factor
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) { // Add the other factor if it's not a perfect square
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }
}

