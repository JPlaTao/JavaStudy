package controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class UserSessionListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        //判断监听到的 Session 被修改的值是否为 username
        if (Objects.equals(se.getName(), "username")) {
            System.out.println("用户"+se.getValue()+"上线");
            //---------------------下面要做的是---------------------
            // 获取 application作用域中
            // 保存用户名与其 session的 map
            // userSessionMap<String sessionID,HttpSession session>
            //----------------------------------------------------
            // 从 session 中获取 ServletContext
            ServletContext servletContext = se.getSession().getServletContext();
            // 从 ServletContext 中获取 userSessionMap<String,HttpSession> 并强转
            ConcurrentHashMap<String, HttpSession> userSessionMap =
                    (ConcurrentHashMap<String, HttpSession>)
                            servletContext.getAttribute("userSessionMap");
            // 将获取到的sessionID与其对应的 Session 放入该 map
            userSessionMap.put(se.getSession().getId(),se.getSession());
        }
    }
}
