package controller.servlets.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import utils.*;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userName = req.getParameter("user");
//        req.getServletContext().setAttribute();
        String id = req.getSession().getId();
        req.getSession().setAttribute("user", userName);
        if (userName != null) {
            PublicMap.userSessionIDMap.put(id, userName);
        }
    }
}
