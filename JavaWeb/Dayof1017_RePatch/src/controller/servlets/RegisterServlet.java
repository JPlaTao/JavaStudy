package controller.servlets;

import com.wf.captcha.utils.CaptchaUtil;
import dao.UserDao;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("register.html").forward(req,resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        //解析请求 获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm_password");
        String email = req.getParameter("email");
        String verCode = req.getParameter("verCode");

        //验证码
        if (!CaptchaUtil.ver(verCode,req)){
            CaptchaUtil.clear(req);
            writer.write("""
                    <h1>验证码不正确！</h1>
                    """);
            writer.close();
        }

        //空值判断
        if (username == null || password == null || confirmPassword == null) {
            writer.write("""
                    <h1>输入不可为空</h1>
                    <button type="submit">确定</button>
                    """);
            writer.close();
            resp.sendRedirect( req.getContextPath() + "/register");
            return;
        }

        //两次密码验证
        if (!password.equals(confirmPassword)) {
            writer.write("""
                    <h1>两次密码输入需一致</h1>
                    """);
        }

        //注册
        //先判断是否已有账户
        if (!UserDao.isExist(username)) {
            //已有则插入(注册)
            if (UserDao.insert(username, password, email)) {
                writer.write("""
                    <h1>用户注册成功</h1>
                    """);
                writer.close();
            }
            //下面是跳转页面，但只能执行一个 response
//            resp.sendRedirect(req.getContextPath() + "/error.html");

            writer.write("""
                    <h1>用户注册失败</h1>
                    """);
            writer.close();
//            resp.sendRedirect(req.getContextPath() + "/error.html");
        } else{
            writer.write("""
                    <h1>用户已存在，即将进入登录页面</h1>
                    """);
            writer.close();
//            resp.sendRedirect(req.getContextPath() + "/login");
        }
        req.setAttribute("sessionMap",req.getSession()
                .getServletContext()
                .getAttribute("sessionMap"));
    }

}
