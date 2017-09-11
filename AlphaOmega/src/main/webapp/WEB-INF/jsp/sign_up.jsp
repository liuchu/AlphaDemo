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
       <div>
           <h1>Join us</h1>
           <p class="lead">Will tak take you less than 2 minutes to complete register</p>
       </div>

    </div>

    <div class="row clearfix" >

        <div class="col-md-6 column">
            <form class="form-horizontal" role="form" action="/user/doLogin" method="post" id="login_form">
                <h2>Create your own account</h2>
                <div class="form-group">
                    <p><span for="signUpEmail" class="col-sm-2 control-label">Email</span></p>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="signUpEmail" name="signUpEmail" placeholder="Your email"/>
                    </div>
                    <p class="note">This is your email, unique identify of this site, and your login username </p>
                </div>
                <div class="form-group">
                    <p><span for="signUpPassword" class="col-sm-2 control-label">Password</span></p>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="signUpPassword" name="signUpPassword" placeholder="Your password" />
                    </div>
                    <p class="note">Set up your password, use at least one lowercase letter, one numeral, and seven characters. </p>
                </div>
                <div class="form-group">
                    <p><span for="confirmPassword" class="col-sm-2 control-label">Confirm</span></p>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm password" />
                    </div>
                    <p class="note">Double confirm your password</p>
                </div>

                <div class="form-group">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-success" id="sign_up">Create Account</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-6 column">
            <div class="setup-secondary">
                <div class="setup-info-module">
                    <h2>Usage of Alpha</h2>
                    <ul class="features-list">
                        <li><strong>Powerful</strong> communication</li>
                        <li><strong>Free</strong> service</li>

                        <li class="divider"></li>
                        <li>Share your interesting experience</li>
                        <li>Make friends here</li>
                        <li>To learn from others</li>

                    </ul>
                </div>
            </div>
        </div>

    </div>

</div>

<jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>

</body>
</html>
