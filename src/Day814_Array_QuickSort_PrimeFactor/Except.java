package Day814_Array_QuickSort_PrimeFactor;

import java.util.Scanner;

public class Except {
    public static void main(String[] args) {
        int[] arr0 = new int[]{1,2,3,4,5};
        int[] arr1 = new int[]{1,2,4};
        int[] arrNew;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        except(arr0,arr1,arrNew);

//        System.out.println(Arrays.toString(arrNew));
    }
    public static void except (int[] arr0,int[] arr1,int[] arrNew){
        int lenMin = Math.min(arr0.length,arr1.length);
        int lenMax = Math.max(arr0.length,arr1.length);
        for (int i = 0; i < lenMin; i++) {
            for (int j = 0; j < lenMax; j++) {
                if (arr0[i] == arr1[j]){
                    arrNew = new int[i+1];
                    arrNew[i] = arr0[i];
                }
            }
        }
    }
}
