<%@ page import="java.util.concurrent.ConcurrentHashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: platao
  Date: 2023/10/25
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OnlineUser</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<table>
    <tr>
        <th>用户名</th>
        <th>SessionID</th>
        <th>操作</th>
    </tr>
    <%
        ConcurrentHashMap<String, HttpSession> sessionMap =
                (ConcurrentHashMap<String, HttpSession>)
                        request.getSession()
                                .getServletContext()
                                .getAttribute("sessionMap");
        StringBuilder tableRow = new StringBuilder("<tr>");
        for (Map.Entry<String, HttpSession> entry : sessionMap.entrySet()) {
            String k = entry.getKey();
            HttpSession v = entry.getValue();
            String username = (String) v.getAttribute("username");
            String id = v.getId();
            tableRow.append("<td>").append(username).append("</td>");
            tableRow.append("<td>").append(id).append("</td>");
        }
        tableRow.append("</td></table>")
        out.println();
    %>
</table>
</body>
</html>
