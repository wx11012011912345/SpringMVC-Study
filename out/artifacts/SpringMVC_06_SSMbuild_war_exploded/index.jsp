<%--
  Created by IntelliJ IDEA.
  User: 29501
  Date: 2023/4/23
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>书籍</title>

    <style>
      <!--标签选择器：修改页面中所有匹配的标签的样式-->
      a{
        text-decoration: none;
        color: black;
        font-size: 18px;
      }
      h3{
        width:120px;
        height:30px;
        margin:100px auto;
        text-align: center;
        line-height: 18px;
        background: deepskyblue;
        border-radius: 5px;
      }

    </style>

  </head>
  <body>
    <h3>
      <a href="${pageContext.request.contextPath}/book/AllBooks">进入书籍页面</a>
    </h3>
  </body>
</html>
