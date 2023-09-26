import java.util.Arrays;

public class DuoWeiShuZu {
    public static void main(String[] args) {
        int[][][] arr = new int[3][3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][i].length; k++) {
                    arr[i][j][k] = 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][i].length; k++) {
                    System.out.println(Arrays.toString(arr[i][i]));
                }
                System.out.println("------");
            }
            System.out.println("*****");
        }
    }
}
