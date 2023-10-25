package controller.servlets;

import dao.LogDao;
import entity.Log;
import utils.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;


@WebServlet("/upload")
@MultipartConfig(location = "D:\\#Exe_TestFolder\\javaWebUpload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        //获取Session，判断是否登录
        AuthUtil.isLogin(req, resp);
        //请求转发到上传页面 upload.html
        req.getRequestDispatcher("/upload.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");

        //设置响应编码
        resp.setCharacterEncoding("UTF-8");

        //设置响应类型
        resp.setContentType("text/html;charset=utf-8");
        Collection<Part> parts = req.getParts();
//        Part partFile = req.getPart("uploadFile");
        StringBuilder message = new StringBuilder();
        for (Part part : parts) {
            //保存文件并检查异常
            part.write(part.getSubmittedFileName());

            //添加日志
            Log log = LogDao.log(req.getRemoteAddr(),
                    part.getSubmittedFileName(),
                    part.getContentType(),
                    part.getSize() + "bytes",
                    "http://" +
                            req.getLocalAddr() +
                            "/download?fileName=" +
                            part.getSubmittedFileName());
            if (log != null) {
                message.append("<p>").append(part.getSubmittedFileName()).append("上传成功</p>");
            } else {
                message.append("<p>").append(part.getSubmittedFileName()).append("上传失败</p>");
            }
        }
        resp.getWriter().write(message.toString());

//        String fileName = partFile.getSubmittedFileName();

        //单个文件上传逻辑
//        try {
//            //保存文件并检查异常
//            partFile.write(fileName);
//
//            //添加日志
//            LogDao.log(req.getRemoteAddr(),
//                    fileName,
//                    partFile.getContentType(),
//                    partFile.getSize() + "bytes",
//                    "http://10.0.3.138/download?fileName=" + fileName);
//
//            //转发请求到下载列表
//            req.getRequestDispatcher("/downloadList").
//                    forward(req, resp);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            resp.getWriter().write("<h3>上传失败</h3>");
//        }
    }
}


