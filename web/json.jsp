<%@ page import="com.sunland.service.JsonService" %>
<%@ page import="com.sunland.pkg.BasePkg" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: wangzn
  Date: 2018/2/14
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%!
    final static String serviceBean = "jsonService";
    /**service for webservice*/
    static JsonService service = null;

    JsonService getServcie() {
        if (service == null) {
            synchronized (serviceBean) {

                if (service == null) {

                    service = new JsonService();
                }
            }
        }


        return service;
    }
%>
<%
    try {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String requestStr = request.getParameter("request");

//        // BasePkgEncrypted pkg = BasePkgEncrypted.parse(requestStr, BasePkgEncrypted.class);
//        BasePkg pkg = new Gson().fromJson(requestStr, BasePkg.class);
//        String methodName = pkg.getMethod();
//        String jsonString = pkg.getParameter();
//
//        JsonService jservice = getServcie();
//        String ret = jservice.process(methodName, jsonString).trim();
//        String retStr = ret.replaceAll("\"", "\\\\\"");
//
//        ret = "{\"IsEncrypted\":\"false\",\"Method\":\"" + methodName + "\",\"Data\":\"" + retStr + "\"}";
//        System.out.println(requestStr);


        out.print(requestStr);
    } catch (Exception e) {
        out.print("{code:\"2\",message:\"Network error.\"}");
    }
%>

</body>
</html>
