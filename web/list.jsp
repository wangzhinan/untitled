<%--
  Created by IntelliJ IDEA.
  User: wangzn
  Date: 2018/2/3
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="user_findAll" namespace="/">
    <s:textfield name="username" label="用户名" key="Switch"/>
    <s:password name="password" label="密码"/>
    <s:radio name="gender" list="#{'0':'男','1':'女'}" label="性别" value="0" />
    <s:textfield name="age" label="年龄"/>
    <s:select name="city" list="#{'bj':'北京','sh':'上海','gz':'广州','sz':'深圳'}" label="城市" headerKey="-1" headerValue="---请选择城市---" emptyOption="true"/>
    <s:checkboxlist name="hibbies" list="#{'code':'写代码','algorithm':'算法','movie':'电影'}" label="爱好"/>
    <s:checkbox name="married" label="是否已婚" value="true" labelposition="left"/>
    <s:textarea name="description" label="自我介绍" rows="5" cols="20"/>
    <s:file name="phone" label="头像"/>
    <s:submit value="提交"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
