package Practice810;

public class P2SeekMaxIndex {
    public static void main(String[] args) {
        //定义一个5*5的二维数组并初始化，找出数组中的最大值的坐标。

        int[][] arr = new int[][]{
                {4, 32, 5, 3, 5},
                {43, 23, 51, 2, 5},
                {76, 99, 8, 7, 86},
                {54, 8, 86, 98, 49},
                {53, 85, 4, 53, 2},
        };
        int max = 0;
        int indexI = 0;
        int indexJ = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]>max){
                    max = arr[i][j];
                    indexI = i;
                    indexJ = j;
                }
            }
        }
        System.out.println("最大值为："+max +"\t坐标为:"+indexI+"," + indexJ);
    }
}
