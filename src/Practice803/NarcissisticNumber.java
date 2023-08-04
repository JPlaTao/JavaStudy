
public class NarcissisticNumber {
    public static void main(String[] args) {
        for(int i = 100; i<= 999; i++){
            int hundred = i / 100;
            int ten = i % 100 / 10;
            int one = i % 10;
            if( hundred * hundred * hundred + ten * ten * ten + one * one * one == i){
                System.out.println(i);
            }
        }
    }
}