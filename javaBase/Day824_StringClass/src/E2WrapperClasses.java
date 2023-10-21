public class E2WrapperClasses {
    public static void main(String[] args) {
        Integer x = new Integer(100);
        System.out.println(x);
        System.out.println("Integer的最大值" + x.MAX_VALUE);


        Integer y = new Integer("190");
        System.out.println(y);
        System.out.println("Integer最小值：" + y.MIN_VALUE);

        Double d = new Double(1.23);
        System.out.println(d);
        System.out.println("Double最大值：" + d.MAX_VALUE);

        Double e = new Double("3.14");
        System.out.println(e);
        System.out.println("Double最小值：" + e.MIN_VALUE);
    }

}
