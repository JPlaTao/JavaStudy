public class Static {
    public static int id = 0;
    int id1;
    int id2;
    int id3;
    public static void sayId(){
        System.out.println(Static.id);
    }

    public static void main(String[] args) {
//        Static.id = 1;
//        System.out.println(Static.id);
        Static.sayId();
    }
}
