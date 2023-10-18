package dao;

import entity.Log;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DBUtil;

public class LogDao {
    /**
     * 向 log 表中插入一条记录
     * @param params ip, file_name, file_type, file_length
     * @return 插入的记录
     * @throws Exception 数据库异常
     */
    public static Log log(Object... params) {
        try {
            return DBUtil.getQueryRunner().insert(
                    "insert into website.log(" +
                            "ip, file_name, file_type," +
                            " file_length, downloadURL)" +
                            " values(?,?,?,?,?)",
                    new BeanHandler<>(Log.class),
                    params);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
