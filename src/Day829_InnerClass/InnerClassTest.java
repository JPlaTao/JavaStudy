package Day829_InnerClass;

public class InnerClassTest {

    static class InnerStatic {
        private String notStaticString;
        static private String staticString;

        void notStaticMethods() {
            System.out.println("InnerStatic Class.notStaticMethods");
        }

        static void staticMethods() {
            System.out.println("InnerStatic Class.staticMethods");
        }
    }

    public class InnerNotStatic {

        private String notStaticString;
        static private String staticString;

        void notStaticMethods() {
            System.out.println("InnerNotStatic Class.notStaticMethods");
        }

        static void staticMethods() {
            System.out.println("InnerNotStatic Class.staticMethods");
        }
    }
}
