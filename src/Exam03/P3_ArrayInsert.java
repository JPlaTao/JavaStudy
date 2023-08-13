package Exam03;

import java.util.Arrays;
import java.util.Scanner;

public class P3_ArrayInsert {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要插入的位置");
        int key = scanner.nextInt();
        System.out.println("请输入要插入的值");
        int value = scanner.nextInt();
        int[] newArr = new int[arr.length+1];
        arrayInsert(arr,key,value,newArr);
        System.out.println(Arrays.toString(newArr));
    }
    public static void arrayInsert(int[] arr,int k,int v,int[] newArr){
        System.arraycopy(arr,0,newArr,0,k-1);
        newArr[k-1] = v;
        System.arraycopy(arr,k-1,newArr,k,arr.length-(k-1));
    }
}
