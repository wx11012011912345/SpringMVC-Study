<%--
  Created by IntelliJ IDEA.
  User: 29501
  Date: 2023/4/25
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>更新书籍</title>

    <!--Bootstrap美化界面-->
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix"><!--清除浮动-->
        <div class="col-md-12 column"><!--12列-->
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/UpdateBook" method="post"><!--或action="addBook" 相对路径：相对于http://localhost:8080/SpringMVC_06_SSMbuild/book/toAddBook-->
        <%--出现的问题：我们提交了修改书籍的请求，但是修改失败，初次考虑，是未配置事务，配置完毕后，依旧失败--%>
        <%--看一下sql语句：sql执行失败--%>
        <%--前端触底隐藏域(页面上不显示)--%>
        <input type="hidden" name="bookID" value="${QBook.bookID}"/>
        <!--name属性一定要与Books类中的属性相同，因为传给handler的是个Books的对象-->

        书籍名称：<input type="text" name="bookName" value="${QBook.bookName}" required><br><br><br>
        书籍数量：<input type="text" name="bookCounts" value="${QBook.bookCounts}" required><br><br><br>
        书籍详情：<input type="text" name="detail" value="${QBook.detail}" required><br><br><br>
        <input type="submit" value="修改">
    </form>
</div>
</body>
</html>
