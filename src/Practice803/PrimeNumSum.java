<<<<<<< HEAD
package Practice803;

public class PrimeNumSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i ++){
            boolean flag = true;
            for (int j = 2 ; j <= i;j ++){
                if( i % j == 0 & j != 1 & j !=i)//判断此数不是素数
                {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum += i;
            }
        }
        System.out.println("100以内质数和为：" + sum);
    }
}
=======
package Practice803;

public class PrimeNumSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i ++){
            boolean flag = true;
            for (int j = 2 ; j <= i;j ++){
                if( i % j == 0 & j != 1 & j !=i)//判断此数不是素数
                {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum += i;
            }
        }
        System.out.println("100以内质数和为：" + sum);
    }
}
>>>>>>> bac9f7880edc1ae95209115b3aa78374fda27132
