package Day824_StringClassPractice;

public class E3BoxingAndUnBoxing {
    public static void main(String[] args) {
        //装箱
        int i = 100;
        Integer itgI = new Integer(i);
        Integer itgI2 = Integer.valueOf(i);

        //拆箱
        Integer itgj = new Integer(2);
        int j = itgj.intValue();
        int k = itgj;
    }

}
