package Practice803;

public class VegetableNumber {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i ++){
            boolean flag = true;
            for (int j = 2 ; j <= i;j ++){
                if( i % j == 0 & j != 1 & j !=i)//判断此数不是素数
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
            System.out.println( i + "是素数");
            else continue;
        }
    }
}
