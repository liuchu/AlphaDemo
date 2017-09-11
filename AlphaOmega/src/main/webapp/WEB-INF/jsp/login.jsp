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

<head>
    <title>login</title>
</head>

<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>
<script src="resource/js/login.js"></script>

<div class="container">
    <div class="row clearfix" style="margin-top: 10%">

        <div class="col-md-4 column" style="background-color: #ECECEC">
            <form class="form-horizontal" role="form" action="/user/doLogin" method="post" id="login_form">
                <h2>Sign in</h2>
                <div class="form-group">
                    <!-- <label for="inputEmail3" class="col-sm-2 control-label">Email</label> -->
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="email address"/>
                    </div>
                </div>
                <div class="form-group">
                    <!-- <label for="inputPassword3" class="col-sm-2 control-label">Password</label> -->
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="password" />
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
                            <p> <a href="/sign">Sign Up</a> | <a href="#">Forgot Password?</a></p>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-success" id="sign_in">Sign in</button>
                    </div>
                    <label id="auth_response"></label>
                </div>
            </form>
        </div>

        <div class="col-md-4 column">

        </div>

        <div class="col-md-4 column">

        </div>

    </div>
</div>

<jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>

</body>
</html>
