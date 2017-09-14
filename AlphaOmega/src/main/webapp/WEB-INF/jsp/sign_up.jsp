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

<link href="resource/style/bootstrapValidator.css" rel="stylesheet">

<script src="resource/js/bootstrapValidator.js"></script>
<script src="resource/js/zh_CN.js"></script>
<script src="resource/js/sign_up.js"></script>

<div class="container">

    <div class="row clearfix" style="margin-top: 6%">
       <div>
           <h1>Join us</h1>
           <p class="lead text-muted" >Will tak take you less than 2 minutes to complete register</p>
       </div>

    </div>

    <div class="row clearfix" >

        <div class="col-md-6 column">
            <form class="form-horizontal" role="form" action="user/doSignUp" method="post" id="sign_up_form">
                <h2>Create your own account</h2>

                <dl>
                    <dt><label><strong>Email</strong></label></dt>
                    <dd>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="email" class="form-control" id="signUpEmail" name="signUpEmail"/>
                            </div>
                            <p class="note text-muted" style="text-indent:1em;margin-bottom: 0em">This is your email, unique
                                identify of this site, and your login username. </p>
                        </div>

                    </dd>
                </dl>

                <dl>
                    <dt><label><strong>Displayed name</strong></label></dt>
                    <dd>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" id="displayName" name="displayName"/>
                            </div>
                            <p class="note text-muted" style="text-indent:1em;margin-bottom: 0em">
                                Your name displayed to other folks, you can input your full name
                                or a fake name.
                            </p>
                        </div>

                    </dd>
                </dl>

                <dl>
                    <dt><label><strong>Password</strong></label></dt>
                    <dd>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="password" class="form-control" id="signUpPassword" name="signUpPassword" />
                            </div>
                            <p class="note text-muted" style="text-indent:1em;margin-bottom: 0em">
                                Set up your password, use atleast one lowercase letter, one numeral,and seven characters.
                            </p>
                        </div>
                    </dd>
                </dl>

                <dl>
                    <dt><label><strong>Confirm</strong></label></dt>
                    <dd>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" />
                            </div>
                            <p style="text-indent:1em;margin-bottom: 0em" class="note text-muted">
                                Double confirm your password.
                            </p>
                        </div>
                    </dd>
                </dl>

                <div class="form-group">
                    <div class="col-sm-12">
                        <button type="submit" class="btn btn-success" id="sign_up">Create Account</button>
                    </div>
                    <label id="sign_up_response" style="color: red"></label>
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
