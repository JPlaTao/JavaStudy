package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logList")
public class LogListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                    <td>文件名</td>
                    <td>大小</td>
                    <td>修改时间</td>
                    <td>下载</td>
                </tr>""";


        html += "</table></div>";
    }
}
