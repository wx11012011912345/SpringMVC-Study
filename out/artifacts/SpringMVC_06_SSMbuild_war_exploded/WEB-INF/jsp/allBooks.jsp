<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>书籍展示</title>
    <!--Bootstrap美化界面-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix"><!--清除浮动-->
        <div class="col-md-12 column"><!--12列-->
            <div class="page-header">
                <h1>
                    <small>书籍列表——显示所有数据</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <%--新增书籍  超链接按钮 --%>
                <a href="toAddBook" class="btn btn-primary">新增书籍</a>
                    <!--前面不要加book/，否则url变成http://localhost:8080/SpringMVC_06_SSMbuild/book/book/toAddBook-->
                <!--相对路径是相对于当前url的,它们都在/book/下-->
                <a href="AllBooks" class="btn btn-primary">显示全部书籍</a>
            </div>
            <div class="col-md-4 column"></div>
            <div class="col-md-4 column">
                <%--查询书籍 --%>
                <form action="QueryBook" method="post" style="float:right"><!--右边浮动-->
                    <span style="color:red;font-weight:bold">${error}</span>
                    <input type="text" name="queryBookName" placeholder="请输入书籍名称">
                    <input type="submit" value="查询"/>
                </form>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <!--表头-->
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书记详情</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <!--表体-->
                <tbody>
                    <c:forEach var="book" items="${books}">
<%--                <c:forEach var="book" items="${requestScope.get('list')}">--%>
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="toUpdateBook?id=${book.getBookID()}">修改</a>
                                &nbsp;|&nbsp;<!--&nbsp;表示空格-->
                                <a href="DeleteBook/${book.getBookID()}">删除</a>
                                <!--或绝对路径写法-->
<%--                                <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.getBookID()}">更改</a> |--%>
<%--                                <a href="${pageContext.request.contextPath}/book/del/${book.getBookID()}">删除</a>--%>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
