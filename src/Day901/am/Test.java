package Day901.am;

public class Test {
    public static void main(String[] args) {
        DoubleLinked linked = new DoubleLinked();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        System.out.println(linked);
        System.out.println("contain 3? "+linked.contain(3));
        System.out.println("valueOf index 4: "+linked.get(4));
        System.out.println("valueOf size: "+linked.getSize());
        System.out.println("index of 1:"+linked.indexOf(1));
        linked.remove(5);
        System.out.println("removed 5 :"+linked);
    }
}
