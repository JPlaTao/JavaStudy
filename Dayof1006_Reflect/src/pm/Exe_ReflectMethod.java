package pm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Exe_ReflectMethod {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> musicClass = Music.class;
        Method[] methods = musicClass.getMethods();
        System.out.println(methods.length);
        for (Method method : methods) {
            System.out.println(method.getName());
            method.invoke(new am.Music(),1);
        }

//        Field[] declaredFields = musicClass.getDeclaredFields();
    }
}
//git test
