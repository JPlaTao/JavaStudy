package Day831_ExceptionLine.pm_LinkedTable;

public class Test {
    public static void main(String[] args) {
        LinkedTable lt = new LinkedTable();
        lt.add(1);
        lt.add(2);
        lt.add(3);
        lt.add(4);
        lt.add(5);
        System.out.println(lt);
        System.out.println("contains 5? "+lt.contains(5));
        lt.remove(5);
        System.out.println(lt);
        System.out.println("get 2: "+lt.get(2));
        System.out.println("getSize: "+lt.getSize());
        System.out.println("isEmpty? "+lt.isEmpty());
    }
}
