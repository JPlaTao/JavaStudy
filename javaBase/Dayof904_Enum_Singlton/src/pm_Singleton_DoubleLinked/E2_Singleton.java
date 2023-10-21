package pm_Singleton_DoubleLinked;

public class E2_Singleton {

}

class HungrySingleton{
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton(){
        System.out.println("a hungry singleton");
    }

    public static HungrySingleton getInstance(){
        return INSTANCE;
    }
}

class LazySingleton{
    private static LazySingleton INSTANCE = null;

    private LazySingleton(){
        System.out.println("a lazy singleton");
    }

    public static LazySingleton getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}

class StaticInnerClass{

    private StaticInnerClass(){
        System.out.println("a static inner class singleton");
    }

    static class StaticInnerClassInstance {

        private static StaticInnerClass INSTANCE = null;

        public static StaticInnerClass getInstance() {
            if (INSTANCE == null){
                INSTANCE = new StaticInnerClass();
            }
            return INSTANCE;
        }
    }


}

