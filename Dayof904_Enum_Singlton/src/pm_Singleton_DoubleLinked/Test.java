package pm_Singleton_DoubleLinked;

import java.util.Objects;

public class Test {
    static class TestOfDoubleLinked {
        public static void main(String[] args) {
            DoubleLinked dl = new DoubleLinked();
            dl.add(1);
            dl.add(2);
            dl.add(3);
            dl.add(4);
            dl.add(5);
            System.out.println(dl);
            System.out.println("removed equals 5 ?  " + dl.remove(5).equals(5));
            System.out.println("after removed 5: " + dl);
            System.out.println("contain 1 is true ?  " + dl.contain(1));
            System.out.println("value of 3 equals 4 ? "+ dl.valueOf(3));
            System.out.println("index of 4 equals 3 ?  " + (dl.indexOf(4) == 3));
        }
    }

    static class TestOfSingleton {
        public static void main(String[] args) {
//        HungrySingleton hs = HungrySingleton.getInstance();
//        HungrySingleton hs1 = HungrySingleton.getInstance();

//        LazySingleton ls = LazySingleton.getINSTANCE();
//        LazySingleton ls1 = LazySingleton.getINSTANCE();

//        StaticInnerClass ss = StaticInnerClass.StaticInnerClassInstance.getINSTANCE();
//        StaticInnerClass ss1 = StaticInnerClass.StaticInnerClassInstance.getINSTANCE();
        }
    }
}
