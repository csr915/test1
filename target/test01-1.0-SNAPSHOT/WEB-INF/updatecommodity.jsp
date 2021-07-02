<%--
  Created by IntelliJ IDEA.
  User: 28908
  Date: 2021-06-29
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/updateit">
    id<input type="text" name="id" disabled="disabled" value="${commodities.id}">
    商品名<input type="text" name="commodityname" value="${commodities.commodityname}"><br>
    价格<input type="text" name="price" value="${commodities.price}"><br>
    <input type="submit" value="确定">

</form>

</body>
</html>
