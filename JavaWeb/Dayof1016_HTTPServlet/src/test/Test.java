package test;

import dao.UserDao;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(UserDao.isExist("admin"));
//        System.out.println(UserDao.insert("admin", "12138", "email"));
    }
}
