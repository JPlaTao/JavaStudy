package Practice814_Array_QuickSort_PrimeFactor;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        randomFill(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void randomFill(int[] arr){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(99)+1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int left = start;
        int right = end;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && arr[left] < pivot) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left == right) {
                arr[left] = pivot;
            }
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr, start, right - 1);
        quickSort(arr, left + 1, end);
    }
}
