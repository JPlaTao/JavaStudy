package Practice808;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,1,4,3,};

        for (int i = 1; i < arr.length; i++) {
            int currentNum = arr[i];
            int prevIndex = i - 1;
            for ( ; prevIndex>=0 && currentNum < arr[prevIndex] ; prevIndex-- ) {
                arr[prevIndex + 1] = arr[prevIndex];
            }
            arr[prevIndex+1] = currentNum;
        }
        for (int i: arr
             ) {
            System.out.print(i + " ");
        }
    }
}
