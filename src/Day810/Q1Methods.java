package Day810;

public class Q1Methods {
    public static void main(String[] args) {
//        System.out.println(isPalindromeNumber(1221));
        System.out.println(calculator('1',8,8));
    }

    public static boolean isEvenAndDivisibleByThree(int number) {
        return number % 2 == 0 && number % 3 == 0;
    }

    public static boolean isPositiveAndGreaterThanTen(double number) {
        return number > 10;
    }

    public static boolean isInValidRange(int number) {
        return number >= 0 && number <= 100;
    }

    public static boolean isBothConditionsTrue(boolean condition1, boolean condition2) {
        return condition1 && condition2;
    }

    public static boolean isPalindromeNumber(int number) {
        int num = number;
        int newNum = 0;
        while (num != 0) {
            newNum *= 10;
            newNum += num % 10;
            num = num / 10;
        }
        return number == newNum;
    }

    public static double calculator(char oper,double num1,double num2){
        return switch (oper){
            case '+' -> num1 + num1;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            case '%' -> num1 % num2;
            default -> {
                System.out.println("输入的操作符有误");
                yield -111.111;}
        };
    }

}
