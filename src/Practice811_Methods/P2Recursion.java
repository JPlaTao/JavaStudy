package Practice811_Methods;

public class P2Recursion {
    public static void main(String[] args) {
        System.out.println(factorial(6));
        System.out.println(fibonacci(6));
    }

    public static int factorial(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static int fibonacci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fibonacci(num - 1)+fibonacci(num-2);
    }
}

