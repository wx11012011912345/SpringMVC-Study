<%--
  Created by IntelliJ IDEA.
  User: 29501
  Date: 2023/4/24
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>新增书籍</title>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <!--Bootstrap美化界面-->
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix"><!--清除浮动-->
        <div class="col-md-12 column"><!--12列-->
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/AddBook" method="post"><!--或action="addBook" 相对路径：相对于http://localhost:8080/SpringMVC_06_SSMbuild/book/toAddBook-->
        书籍名称：<input type="text" name="bookName" required><br><br><br>
        书籍数量：<input type="text" name="bookCounts" required><br><br><br>
        书籍详情：<input type="text" name="detail" required><br><br><br>
        <input type="submit" value="添加">
    </form>

</div>

</body>
</html>
