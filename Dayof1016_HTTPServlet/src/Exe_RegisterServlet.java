import dao.UserDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Exe_HTTPServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm_password");
        String email = req.getParameter("email");
        if (username == null||password == null || confirmPassword == null){
            System.out.println("输入不可为空");
            return;
        }
        if (!password.equals(confirmPassword)){
            System.out.println("两次输入密码需一致！");
            return;
        }
        if (!UserDao.isExist(username)){
            System.out.println("用户已存在！");
            if (UserDao.insert(username,password,email)) {
                System.out.println("用户注册成功");
                return;
            }
            System.out.println("用户注册失败");
        }
    }
}
