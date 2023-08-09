package Practice809;

public class Q2Rank {
    public static void main(String[] args) {
        String[] names = {"安琪拉","王昭君","蔡文姬","妲己","张良"};
        String[] courses = {"C++","Java","Python"};

        int[][] scores = {
                {98,89,75},
                {59,40,100},
                {100,99,80},
                {80,61,61},
                {60,100,99},
        };

        //输出成绩表
        for (int i = 0; i < scores.length; i++) {
            System.out.print(names[i] + "=>");//输出学生姓名
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(courses[j] + ":");//输出课程名称
                System.out.print(scores[i][j]);//输出课程成绩
                if (j<scores[i].length-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < scores[i].length; i++) {
        }

    }
}
