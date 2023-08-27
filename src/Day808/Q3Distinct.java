package Day808;

public class Q3Distinct {
    public static void main(String[] args) {

        int[] arr = new int[]{5,1,3,3,8,4,1,5,4,3};//初始化一个数组
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int repeatCount = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length - repeatCount; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = arr[arr.length - 1 - repeatCount];
                    repeatCount++;
                    j--;
                }
            }
        }
        int[] arrNew = new int[repeatCount];
        for (int i = 0; i < arr.length-repeatCount; i++) {
            arrNew[i] = arr[i];
        }
        for (int i : arrNew) {
            System.out.print(i + " ");
        }
    }
}
