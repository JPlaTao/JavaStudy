package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;


@WebServlet("/upload")
@MultipartConfig(location = "D:\\#Exe_TestFolder\\javaWebUpload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/upload.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        Part file = req.getPart("uploadFile");
        String fileName = file.getSubmittedFileName();

//        fileName = "D:\\#Exe_TestFolder\\javaWebUpload"
//                + File.separator + fileName;
        try {
            file.write(fileName);
            req.getRequestDispatcher("/downloadList").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.getWriter().write("<h3>上传失败</h3>");
        }
    }
}


