<%--
  Created by IntelliJ IDEA.
  User: chuliu
  Date: 2017/8/29
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

<div class="container">
    <div class="row clearfix" style="margin-top: 10%">
        <div class="col-md-12 column">

            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#">My posts</a>
                </li>
                <li>
                    <a href="#">My replies</a>
                </li>
                <li >
                    <a href="#">Favorite topics</a>
                </li>
            </ul>

        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-8 column">
            <p>Display issues list here</p>
        </div>

        <div class="col-md-4 column">
            <p>Some issue tool here </p>
            <p>Or some tips </p>
        </div>

    </div>
</div>

<jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>

</body>
</html>
