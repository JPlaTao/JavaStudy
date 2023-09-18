package Test;

public class InsertSortTest {
    public static void main(String[] args) {
        int[] arr = {4,6,2,5,1,3};
        insertSort(arr);
    }


    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int currNum = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index]>currNum) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = currNum;
        }
        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }



}
