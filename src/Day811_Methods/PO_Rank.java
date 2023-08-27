package Day811_Methods;

import java.util.Arrays;

public class PO_Rank {
    public static void main(String[] args) {
        String[] names = {"安琪拉","王昭君","蔡文姬","妲己","张良"};
        String[] courses = {"C++","Java","Python"};
                //[5][3]  scores.length = 3
        int[][] scores = {
                {98,89,75},
                {59,40,100},
                {100,99,80},
                {80,61,61},
                {60,100,99},
        };
        sortArray(scores,0,0);

//        //输出成绩表
//        for (int i = 0; i < scores.length; i++) {
//            System.out.print(names[i] + "=>");//输出学生姓名
//            for (int j = 0; j < scores[i].length; j++) {
//                System.out.print(courses[j] + ":");//输出课程名称
//                System.out.print(scores[i][j]);//输出课程成绩
//                if (j<scores[i].length-1){
//                    System.out.print(", ");
//                }
//            }
//            System.out.println();
//        }
    }
    
    public static void printScore(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);//输出课程成绩
                if (j<arr[i].length-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
    
    
    public static void sortArray(int[][] arr, int sortByIndex, int printByIndex){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j][sortByIndex] < arr[j+1][sortByIndex]){
                    int[] temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr[printByIndex]));
    }

    public static void sortArray(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
