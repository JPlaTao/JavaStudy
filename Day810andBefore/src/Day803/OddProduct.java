package Day803;

public class OddProduct {
    public static void main(String[] args) {
        int result = 1;
        for (int i = 9; i >= 1;i -= 2){
            result *= i;
        }
        System.out.println(result);
    }
}
