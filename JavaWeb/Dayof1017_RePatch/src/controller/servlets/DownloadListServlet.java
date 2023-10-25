package controller.servlets;

import utils.AuthUtil;
import utils.FormatUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/downloadList")
public class DownloadListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("application/octet-stream");
//        resp.setHeader("content-disposition","attachment",);

        //设置编码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        //获取session，判断是否登录
        AuthUtil.isLogin(req,resp);
        File directory = new File("D:\\#Exe_TestFolder\\javaWebUpload");
        File[] files = directory.listFiles();
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
        for (File file : files) {
            html += "<tr><td>" +
                    file.getName() + "</td><td>" +
                    FormatUtil.toMB(file.length()) + "KB</td><td>" +
                     FormatUtil.formattedDateTime(file.lastModified())  + "</td><td>" +
                    "<a href=\"/download?" +
                    "file" +
                    "=" +
                    file.getName() +
                    "\">下载</a> </td></tr>";
        }
        html += "</table></div>";
        PrintWriter writer = resp.getWriter();
        writer.write(html);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
