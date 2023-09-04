package Day831_ExceptionLine.pm_LinkedTable;

public class Test {
    public static void main(String[] args) {
        LinkedTable lt = new LinkedTable();
        lt.add(2);
        lt.add("contains 5");
        lt.add(3);
        lt.add(4);
        lt.add(5);
        System.out.println(lt);
        System.out.println("contains 5? "+lt.contains(5));
        lt.remove(5);
        System.out.println(lt);
        System.out.println("valueOf 2: "+lt.valueOf(2));
        System.out.println("getSize: "+lt.getSize());
        System.out.println("isEmpty? "+lt.isEmpty());
        for (int i = 0; i < lt.getSize(); i++) {
            System.out.print(lt.valueOf(i)+", ");
        }
        System.out.println();
        System.out.println(lt.indexOf(66));
    }
}
