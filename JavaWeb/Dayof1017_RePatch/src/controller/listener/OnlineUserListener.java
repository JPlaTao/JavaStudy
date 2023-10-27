package controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineUserListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //创建存储用户 session的 ConcurrentHashMap<sessionID,Session>
        ConcurrentHashMap<String, HttpSession> SessionMap =
                new ConcurrentHashMap<>();
        // 获取ServletContext 并存入 sessionMap
        sce.getServletContext().setAttribute("sessionMap",SessionMap);
    }
}
