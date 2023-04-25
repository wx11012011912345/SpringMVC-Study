<%--
  Created by IntelliJ IDEA.
  User: 29501
  Date: 2023/4/25
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.4.js"></script>

    <script>
      $.post({
        url:"${pageContext.request.contextPath}/a1",
        data:{"name":$("#username").val()},
        success:function(data,status){
          console.log("data="+data);
          console.log("status="+status)
        }
      })

    </script>

  </head>
  <body>

  <!--失去焦点的时候，发起一个请求（携带数据）到后端-->
  用户名：<input type="text" id="username" onblur="">
  <p>${pageContext.request.contextPath}</p>

  </body>
</html>
