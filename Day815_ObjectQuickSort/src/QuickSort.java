import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 1, 3};
        quickSort0(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int left = start;
        int right = end;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[left] = arr[left] ^ arr[right];
                arr[right] = arr[left] ^ arr[right];
                arr[left] = arr[left] ^ arr[right];
            }
        }
        arr[start] = arr[right];
        arr[right] = pivot;

        quickSort(arr, start, right - 1);
        quickSort(arr, left + 1, end);
    }

    public static void quickSort0(int[] arr, int start, int end) {
        if (start >= end) return;
        int left = start, right = end;
        int pivot = arr[left];
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && arr[left] < pivot) {
                left++;
            }
            if (left < right)
                arr[right] = arr[left];
            if (left == right) {
                arr[left] = pivot;
            }
        }
        quickSort0(arr,start,right-1);
        quickSort0(arr,left+1,end);
    }
}
