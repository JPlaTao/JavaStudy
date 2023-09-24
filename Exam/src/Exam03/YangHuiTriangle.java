package Exam03;

import java.util.Arrays;
import java.util.Scanner;

public class YangHuiTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入杨辉三角的高度：");
        int H = scanner.nextInt();
        int[][] yangHuiTri = new int[H][];
        for (int i = 0; i < yangHuiTri.length; i++) {
            yangHuiTri[i] = new int[i + 1];
            yangHuiTri[i][0] = 1;
            yangHuiTri[i][i] = 1;
        }
        fillTriangle(yangHuiTri);
        for (int i = 0; i < yangHuiTri.length; i++) {
            System.out.println(Arrays.toString(yangHuiTri[i]));
        }

    }
    public static void fillTriangle(int[][] arr){
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length-1; j++) {
                arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
            }
        }
    }
}
