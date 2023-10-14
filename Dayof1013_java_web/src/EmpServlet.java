import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/emp")
public class EmpServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse)
            throws ServletException, IOException {
        try {
            Statement stat = new Statement();
            stat.query("select * from test.emp");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

