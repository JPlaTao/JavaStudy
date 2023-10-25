package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AuthUtil {
    public static void isLogin(HttpServletRequest req, HttpServletResponse resp){
        String username = (String) req.getSession().getAttribute("username");
        if (username == null) {
            try {
                resp.sendRedirect("/login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    Executor executor = Executors.newFixedThreadPool(10);
    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);


    public static boolean isAdmin(HttpServletRequest req, HttpServletResponse resp){
        String username = (String) req.getSession().getAttribute("username");
        return username.equals("admin");
    }
}
