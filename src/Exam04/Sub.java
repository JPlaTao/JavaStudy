package Exam04;

public class Sub extends Super{
    static Super s1 = new Super(1);
    Super s2 = new Super(3);
    Sub(int i) {
        super(i);
        System.out.println("Sub" + i + ",");
    }
    public static void main(String[] args){
        Super c1 = new Sub(2);
    }
}

class Super{
    Super (int i){
        System.out.println("Super" + i + ",");
    }
}