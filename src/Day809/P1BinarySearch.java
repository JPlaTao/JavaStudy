package Day809;

import java.util.Scanner;

public class P1BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入目标值");
        int tar = scanner.nextInt();

        int left = 0;
        int right = arr.length-1;
        int mid = (left+right) / 2;
        while (left <= right) {
            if (arr[mid] == tar){
                System.out.println("目标值"+ tar+"的下标为：" + mid);
                break;
            } else if (arr[mid] > tar){
                right = mid - 1;

            }else{
                left = mid + 1;
            }
            mid = (left+right) / 2;
        }
        if (left > right) System.out.println(-1);
    }
}
