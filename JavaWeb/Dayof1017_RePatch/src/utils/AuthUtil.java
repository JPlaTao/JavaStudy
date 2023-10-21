package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    public static boolean isAdmin(HttpServletRequest req, HttpServletResponse resp){
        String username = (String) req.getSession().getAttribute("username");
        return username.equals("admin");
    }
}
