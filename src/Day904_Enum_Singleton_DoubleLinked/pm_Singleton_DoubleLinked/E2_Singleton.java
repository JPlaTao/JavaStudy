package Day904_Enum_Singleton_DoubleLinked.pm_Singleton_DoubleLinked;

public class E2_Singleton {

}

class HungrySingleton{
    private static final HungrySingleton instance = new HungrySingleton();

    HungrySingleton(){
        System.out.println("a hungry singleton");
    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}

class LazySingleton{
    private static LazySingleton instance = null;

    private LazySingleton(){
        System.out.println("a lazy singleton");
    }

    public static LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

class StaticInnerClass{

    private StaticInnerClass(){
        System.out.println("a static inner class singleton");
    }

    static class StaticInnerClassInstance {

        private static StaticInnerClass instance = null;

        public static StaticInnerClass getInstance() {
            if (instance == null){
                instance = new StaticInnerClass();
            }
            return instance;
        }
    }


}

