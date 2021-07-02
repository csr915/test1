<%--
  Created by IntelliJ IDEA.
  User: 28908
  Date: 2021-06-29
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCommodity</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/addcommodity">

    商品名<input name="commodityname"><br>
    价格<input name="price"><br>
    <input type="submit" value="确定">

</form>

</body>
</html>
