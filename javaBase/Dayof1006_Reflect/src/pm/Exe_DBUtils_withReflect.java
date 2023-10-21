package pm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exe_DBUtils_withReflect {
    <E> Object toObject(ResultSet resultSet,Class<E> cls)
            throws NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException,
            SQLException {
        E instance = cls.getConstructor().newInstance();
        Field[] fields = resultSet.getClass().getFields();
        for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
            fields[i].set(instance,resultSet.getObject(fields[i].getName()));
        }
        return instance;
    }
}
