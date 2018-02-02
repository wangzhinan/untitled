<%--
  Created by IntelliJ IDEA.
  User: wangzn
  Date: 2018/2/1
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>welcome to my wesite</title>
</head>
<body>
<s:form action="user_save" method="POST" namespace="/" theme="simple">
    <table border="1" width="400">
        <tr>
            <td>姓名</td>
            <td><s:textfield name="name"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><s:textfield name="password"/> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="注册"/> </td>
        </tr>
    </table>
</s:form>

</body>
</html>
