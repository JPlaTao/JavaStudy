package Practice823;

public class Suffix {

    public static void main(String[] args) {
        System.out.println(getSuffix("hello world.java"));
    }

    public static String getSuffix(String str){
        int index = str.lastIndexOf(".");
        return str.substring(index);
    }
}
