package dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

public class DBUtils {

    private static DataSource dataSource = null;

    public static QueryRunner getQueryRunner() throws Exception {
        return new QueryRunner(getDataSource());
    }

    private static DataSource getDataSource() throws Exception {
        if (dataSource == null) {
            Properties druidProper = new Properties();
            druidProper.load(new FileInputStream(
                    "D:\\4.WorkSpace\\JAVA\\java-study\\Properties\\DruidProp.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(druidProper);
        }
        return dataSource;

    }

}
