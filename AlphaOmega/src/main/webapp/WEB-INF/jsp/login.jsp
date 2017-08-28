<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: chuliu
  Date: 2017/8/16
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<html>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<head>
    <title>登陆</title>
</head>

<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

<div class="container">
    <div class="row clearfix" style="margin-top: 10%">

        <div class="col-md-4 column" style="background-color: #ECECEC">
            <form class="form-horizontal" role="form" action="/user/doLogin" method="post">
                <h2>Sign in</h2>
                <div class="form-group">
                    <!-- <label for="inputEmail3" class="col-sm-2 control-label">Email</label> -->
                    <div class="col-sm-10">
                        <input type="email" class="form-control" name="inputEmail" placeholder="email address"/>
                    </div>
                </div>
                <div class="form-group">
                    <!-- <label for="inputPassword3" class="col-sm-2 control-label">Password</label> -->
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="inputPassword" placeholder="password" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-10">
                        <div class="checkbox">
                            <label><input type="checkbox" name="inputRemember"/>Remember me</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-10">
                        <div class="span">
                            <p>Not registered?</p>
                            <p> <a href="#">Sign Up</a> | <a href="#">Forgot Password?</a></p>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-success">Sign in</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-4 column">

        </div>

        <div class="col-md-4 column">

        </div>

        <div class="col-md-3 column">

        </div>

    </div>
</div>

<jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>
</body>
</html>
