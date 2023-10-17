package servlet;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CaptchaUtil.out(5, req, resp);
        req.getRequestDispatcher("login.html").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        //解析请求，获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
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
        if (username == null || password == null) {
            writer.write("""
                    <h1>输入不可为空</h1>
                    """);
            writer.close();
        }
        //验证账户密码
        if (UserDao.isExist(username,password)){
            resp.sendRedirect(req.getContextPath() +"/welcome");
        }
        writer.write("""
                    <h1>用户名或密码不正确！</h1>
                    """);
        writer.close();
    }





}
