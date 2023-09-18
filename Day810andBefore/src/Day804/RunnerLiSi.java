package Day804;

public class RunnerLiSi {
    public static void main(String[] args) {
        int searchDay = 10;
        int week = searchDay / 7;
        int monday = 0;
        int distance = 0;
        for (int i = 0; i < week; i++) {
            monday += 100;
            int dayRunDis = monday;
            for (int j = 1; j <= 7; j++) {
                distance += dayRunDis;
                dayRunDis += 100;
            }
        }
        int dayRunDis = monday + 100;
        for (int i = 0; i < searchDay % 7; i++) {
                distance += dayRunDis;
                dayRunDis += 100;
        }
        System.out.println(distance);
    }
}