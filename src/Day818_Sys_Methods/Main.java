package Day818_Sys_Methods;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4,6,2,5,1,3};
        System.out.println(ToolClass.sum(1000));
        ToolClass.insertSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ToolClass.binarySearch(arr, 1));
    }
}
