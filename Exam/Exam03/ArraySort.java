package Exam03;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        String[] names = {"安琪拉","王昭君","蔡文姬","妲己","张良"};
        String[] courses = {"C++","Java","Python"};

        int[][] scores = {
                {98,89,75},
                {59,40,100},
                {100,99,80},
                {80,61,61},
                {60,100,99},
        };
        sortArray(names,scores,2);
    }

    public static void sortArray(String[] arrStr,int[][] arrInt,int sortBy){
        for (int i = 0; i < arrInt.length-1; i++) {
            for (int j = 0; j < arrInt.length-1-i; j++) {
                if (arrInt[j][sortBy] < arrInt[j+1][sortBy]){
                    int[] temp = arrInt[j];
                    arrInt[j] = arrInt[j+1];
                    arrInt[j+1] = temp;

                    String temp1 = arrStr[j];
                    arrStr[j] = arrStr[j+1];
                    arrStr[j+1] = temp1;
                }
            }
        }
        for (int i = 0; i < arrStr.length; i++) {
            System.out.print(arrStr[i] + ":\t");
//            for (int j = 0; j < arrInt[i].length; j++) {
//                System.out.print(arrInt[i][j] + "\t");
//            }
            System.out.println(Arrays.toString(arrInt[i]));
//            System.out.println();
        }
    }
}
