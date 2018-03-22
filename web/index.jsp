<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/1 0001
  Time: 下午 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $ENDd$
  <s:fielderror value="errors"/>
  <table>
    <s:iterator value="list" var="d">
      <tr>
        <td><s:property value="#d.password"/></td>
      </tr>
    </s:iterator>
  </table>
  <s:debug>debug</s:debug>
  </body>
</html>
