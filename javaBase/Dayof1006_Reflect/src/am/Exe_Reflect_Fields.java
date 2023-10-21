package am;

import java.lang.reflect.Field;

public class Exe_Reflect_Fields {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<?> musicClass = Music.class;
        Field[] fields = musicClass.getFields();
        System.out.println(fields.length);
        Field[] declaredFields = musicClass.getDeclaredFields();


        System.out.println(declaredFields.length);
        System.out.println(musicClass.getDeclaredField("name"));
    }
}
