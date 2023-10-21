package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Exe_RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm_password");
        String email = req.getParameter("email");
        if (username == null || password == null || confirmPassword == null) {
            System.out.println("输入不可为空");
            return;
        }
        System.out.println("输入不为空");
        if (!password.equals(confirmPassword)) {
            System.out.println("两次输入密码需一致！");
            return;
        }
        System.out.println("两次密码一致");
        if (!UserDao.isExist(username)) {
            if (UserDao.insert(username, password, email)) {
                System.out.println("用户注册成功");
                return;
            }
            System.out.println("用户注册失败");
        } else
            System.out.println("用户已存在");
    }
}
