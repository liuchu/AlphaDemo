<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: chuliu
  Date: 2017/8/22
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>

<head>
    <title>Title</title>
</head>

<body>

<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

<div class="container" >

    <shiro:guest>
    <div class="row" style="margin-top: 10%">
        <div class="jumbotron" >
            <h1>
                Hello, Guest!
            </h1>
            <p>
                    This is a template for a simple marketing or informational website. It includes a large callout
                    called the hero unit and three supporting pieces of content. Use it as a starting point to create
                    something more unique.
            </p>
            <p>
                Currently you are accessed as guest, try to:
            </p>
            <p>
                <a class="btn btn-primary btn-large" href="/login">Sign in</a>
            </p>
        </div>
    </div>
    </shiro:guest>

    <shiro:authenticated>
        <div class="row" style="margin-top: 10%">
            <div class="jumbotron" >
                <h1>
                    Hello, <shiro:principal/>!
                </h1>
                <p>
                    Welcome to Alpha!
                </p>
                <p>
                    You can learn more about Alpha here:
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Document</a>
                </p>
            </div>
        </div>
    </shiro:authenticated>

</div>

<jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>
</body>

</html>
