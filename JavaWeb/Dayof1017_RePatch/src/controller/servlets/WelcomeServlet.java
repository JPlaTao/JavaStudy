package controller.servlets;

import dao.UserDao;
import entity.User;
import utils.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //获取Session，判断是否登录
        AuthUtil.isLogin(req, resp);
        req.getRequestDispatcher("welcome.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        if (!AuthUtil.isAdmin(req,resp)) {
            resp.getWriter().write("<h1>您不是管理员，无权访问！</h1>");
            return;
        }
        List<User> userList = UserDao.selectAll();
        String html = """
                <style>
                *{
                margin:0;
                padding:0;
                }
                td,tr,table{
                border:1px solid black;
                }
                div{
                display:flex;
                justify-content:space-around;
                margin:20px auto;
                }
                </style>
                <div>
                <table>
                <tr>
                    <td>id</td>
                    <td>username</td>
                    <td>email</td>
                </tr>""";
        for (User user : userList) {
            html += "<tr><td>" +
                    user.getId() + "</td><td>" +
                    user.getUsername() + "</td><td>" +
                    user.getEmail() + "</td></tr>";
        }
        html += "</table></div>";
        PrintWriter writer = resp.getWriter();
        writer.write(html);
        writer.close();
    }
}
