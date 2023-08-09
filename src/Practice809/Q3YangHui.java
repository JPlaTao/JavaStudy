package Practice809;

public class Q3YangHui {
    public static void main(String[] args) {
        int[][] tri = new int[8][8];
        for (int i = 0; i < tri.length; i++) {
            tri[i][0] = 1;
            tri[i][i] = 1;
        }



        for (int i = 2; i < tri.length ; i++) {
            for (int j = 1; j <=i ; j++) {
                tri[i][j] = tri[i - 1][j-1] + tri[i-1][j];
            }
        }
        int control = tri.length-1;
        for (int i = 0; i < tri.length; i++) {
            for (int j = 0; j < tri.length-control; j++) {
                System.out.print(tri[i][j] + "\t");
            }
            control--;
            System.out.println();
        }
    }
}

