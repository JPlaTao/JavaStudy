package Day810;


public class P3SeekMinSum {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {54, 32, 5, 3, 5},
                {43, 12, 51, 2, 5},
                {76, 9, 8, 7, 86},
                {54, 8, 86, 98, 49},
                {53, 85, 4, 53, 2},
        };
        System.out.println("最小值为:" + seekMaxValue(arr)
                + "\t坐标为:" + seekMaxIndexRow(arr)
                + "," + seekMaxIndexCol(arr)
                + "\t周围值的和为:"
                + aroundSum(arr, seekMaxIndexRow(arr), seekMaxIndexRow(arr))
        );
    }

    public static int seekMaxValue(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] < max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    public static int seekMaxIndexRow(int[][] arr) {
        int min = arr[0][0];
        int row = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    row = i;
                }
            }
        }
        return row;
    }

    public static int seekMaxIndexCol(int[][] arr) {
        int min = arr[0][0];
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    col = j;
                }
            }
        }
        return col;
    }

    public static int aroundSum(int[][] arr, int rowIndex, int colIndex) {
        int sum = arr[rowIndex - 1][colIndex - 1]//左上
                + arr[rowIndex - 1][colIndex]//正上
                + arr[rowIndex - 1][colIndex + 1]//右上
                + arr[rowIndex][colIndex - 1]//正左
                + arr[rowIndex][colIndex]//正中
                + arr[rowIndex][colIndex + 1]//正右
                + arr[rowIndex + 1][colIndex - 1]//左下
                + arr[rowIndex + 1][colIndex]//正下
                + arr[rowIndex + 1][colIndex + 1];//右下
        return sum;
    }

}
