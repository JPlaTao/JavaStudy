package Practice811_Methods;

import java.util.Arrays;

public class P2_MoreMethods {

    public static void main(String[] args) {
        char[][] poem = new char[][]{
                {'十', '年', '生', '死', '两', '茫', '茫'},
                {'千', '里', '孤', '坟'},
                {'无', '处', '话', '凄', '凉'},
                {'纵', '使', '相', '逢', '应', '不', '识'},
                {'尘', '满', '面'},
                {'鬓', '如', '霜'},
                {'夜', '来', '幽', '梦', '忽', '还', '乡'},
                {'小', '轩', '窗'},
                {'正', '梳', '妆'},
                {'相', '顾', '无', '言'},
                {'惟', '有', '泪', '千', '行'},
                {'料', '得', '年', '年', '肠', '断', '处'},
                {'明', '月', '夜'},
                {'短', '松', '冈'},
        };
        int arr[] = {1,2,3,4,5};
//        overTurn(poem);
//        System.out.println(isPalindromeNumber(12321));
//        System.out.println(isPrimeNumber(5));
        exchange(arr,2,4);
        System.out.println(Arrays.toString(arr));

    }


    public static int sum(int a, int b) {
        return a + b;
    }

    public static int factorial(int a) {
        if (a == 1 || a == 0) {
            return 1;
        }
        return a * factorial(a - 1);
    }

    public static boolean isPrimeNumber(int num) {
        for (int i = 1; i < num / 2; i++) {
            if (num % i == 0 && i != num) {
                return false;
            }
        }
        return true;
    }

    public static void overTurn(char[][] arr) {
        int maxLenIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > arr[maxLenIndex].length) maxLenIndex = i;
        }

        for (int i = 0; i < arr[maxLenIndex].length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if (i <= arr[j].length - 1) {
                    System.out.print(arr[j][i] + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }


    public static boolean isPalindromeNumber(int a){
        int num = a;
        int newNum = 0;
        while (num!=0){
            newNum *= 10;
            newNum += num %10;
            num /= 10;
        }
        return newNum == a;
    }

    public static void exchange(int[] arr,int positionA,int positionB){
        arr[positionA] = arr[positionA]^arr[positionB];
        arr[positionB] = arr[positionA]^arr[positionB];
        arr[positionA] = arr[positionA]^arr[positionB];
    }

    public static void moveLeft(int[] arr,int k){
        for (int i = 0; i < k; i++) {

        }
    }

}
