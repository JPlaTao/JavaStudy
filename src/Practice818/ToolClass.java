package Practice818;

public class ToolClass {


    /**
     *
     * @param n: start form 2 to n end
     * @return int sum Of Prim Number
     */
    public static int sum(int n) {
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if ((isPrimeNum(i))) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     *
     * @param n
     * @return boolean; n is prime? true : false
     */
    private static boolean isPrimeNum(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        System.out.println(n);
        return true;
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currNum = arr[i];
            int index = i - 1;
            while (index >= 0 && currNum < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = currNum;
        }
    }


    public static int binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == n) return mid;
            if (arr[mid] > n) {
                right = mid - 1;
            }
            if (arr[mid] < n) {
                left = mid + 1;
            }
        }
        return -1;
    }


}
