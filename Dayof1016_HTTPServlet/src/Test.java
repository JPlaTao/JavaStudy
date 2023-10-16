import dao.UserDao;
import dao.Utils;
import org.apache.commons.dbutils.QueryRunner;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(UserDao.isExist("admin"));
//        System.out.println(UserDao.insert("admin", "12138", "email"));
    }
}
