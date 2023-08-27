package Day804;


public class PrintNum {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            int count = 0;
            int j = i;
            while (j >= 1)
            {
                j /= 10;
                count++;
            }
            switch (count){
                case 1 -> {
                    if( i == 3 || i == 5 || i == 7)
                                continue;
                }
                case 2 -> {
                    if( i % 10 == 3 || i % 10 == 5 || i %10 == 7)
                        continue;
                }
            }
            System.out.println(i);
            //System.out.println("此数是"+ count + "位数");
        }
    }
}
