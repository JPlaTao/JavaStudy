package Day809;

public class Q1ChunXiao {
    public static void main(String[] args) {
        char[][] chunxiao = {
                {'春', '眠', '不', '觉', '晓'},
                {'处', '处', '闻', '啼', '鸟'},
                {'夜', '来', '风', '雨', '声'},
                {'花', '落', '知', '多', '少'}
        };

        //(1)
        for (int i = 0; i < chunxiao.length; i++) {
            for (int j = 0; j < chunxiao.length+1; j++) {
                System.out.print(chunxiao[i][j] + " ");
            }
            System.out.println();
        }

        //(2)
        char[][] newChunxiao = new char[5][4];

        for (int i = 0; i < newChunxiao.length; i++) {
            for (int j = 0; j < newChunxiao[i].length; j++) {
                newChunxiao[i][j] = chunxiao[newChunxiao[i].length-1-j][i];
            }
        }

        for (int i = 0; i < newChunxiao.length; i++) {
            for (int j = 0; j < newChunxiao[i].length; j++) {
                System.out.print(newChunxiao[i][j] + " ");
            }
            System.out.println();
        }

    }
}
