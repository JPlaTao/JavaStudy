package com.kfm.springstudent.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadDataSource {
    public static Properties properties;
    static {
        properties = new Properties();
        InputStream resource = LoadDataSource.class.getClassLoader().getResourceAsStream("student.properties");
        try {
            properties.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource()  {
        try {
            return DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
