<%--
  Created by IntelliJ IDEA.
  User: 28908
  Date: 2021-06-29
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<H1>
    index
</H1>
<form action="${pageContext.request.contextPath}/index/search">
   <span>游戏名：</span> <input type="text" name="game_title" value="${title}">
    <span>游戏类型：</span> <input type="text" name="game_type" value="${type}">
    <input type="submit" value="查找">

</form>
<div>
    <table>
<c:forEach items="${games}" var="game">
<tr>
    <td>
        ${game.game_title}
    </td>
    <td>
        ${game.game_type}
    </td>
    <td>
         <a href="${pageContext.request.contextPath}/user/deleteit?id=${game.id}">删除</a>
    </td>
    <td>
            <a href="${pageContext.request.contextPath}/user/updatecommodity?id=${game.id}">更新</a>
    </td>
</tr>
</c:forEach>
    </table>
</div>
</body>
</html>
