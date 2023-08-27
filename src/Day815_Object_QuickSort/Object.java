package Day815_Object_QuickSort;

public class Object {
    public int id;

    public static void print(int id) {
        System.out.println("this Object couldn't print it's id:" + id);
    }

    public static void main(String[] args) {
        Object object = new Object();
        object.id = 1;
        print(object.id);
        Worker worker = new Worker();
        worker.says();
    }
}