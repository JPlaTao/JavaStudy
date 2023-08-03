package Practice803;

public class EvenNumSum {
    public static void main(String[] args) {
        int sum = 0 ;
        for (int i = 0; i <= 100; i +=2)
        {
            sum += i;
        }
        System.out.println(sum);
    }
}
