<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="${pageContext.request.contextPath}/resource/style/bootstrap.css" rel="stylesheet">

<!-- 可选的Bootstrap主题文件（一般不使用） -->
<link src="${pageContext.request.contextPath}/resource/style/bootstrap-theme.min.css"/>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/resource/js/header.js"></script>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" >
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

                <div class="container">

                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="/home">Alpha</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="/issues">Issues</a>
                            </li>
                            <li>
                                <a href="#">My activity</a>
                            </li>

                        </ul>

                        <shiro:authenticated>
                        <form class="navbar-form navbar-left" role="search">
                             <button type="submit" class="btn btn-default">
                            <a href="#my_modal" rel="external nofollow" data-toggle="modal">Create</a>
                             </button>
                        </form>
                        </shiro:authenticated>

                        <ul class="nav navbar-nav navbar-right">

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Management<strong class="caret"></strong></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">Users</a>
                                    </li>
                                    <li>
                                        <a href="#">Issues</a>
                                    </li>
                                    <li>
                                        <a href="#">System</a>
                                    </li>
                                    <li class="divider">
                                    </li>
                                    <li>
                                        <a href="#">Documentk</a>
                                    </li>

                                </ul>
                            </li>
                            
                            <shiro:authenticated>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <shiro:principal/>
                                    <strong class="caret"></strong>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="/profile">Profile</a>
                                    </li>
                                    <li>
                                        <a href="#">Keep1</a>
                                    </li>
                                    <li>
                                        <a href="#">Keep2</a>
                                    </li>
                                    <li class="divider">
                                    </li>

                                    <li>
                                        <a href="/user/doLogout">Logout</a>
                                    </li>

                                </ul>
                            </li>
                            </shiro:authenticated>

                            <shiro:guest>
                                <li>
                                    <a href="/login">Log in</a>
                                </li>
                            </shiro:guest>

                        </ul>
                    </div>

                </div>

            </nav>

        </div>
    </div>

</div>

<!-- 创建一个话题的弹窗内容 -->
<div class="modal fade" id="my_modal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    Create
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="/issue/doCreate" method="post" id="create_form">
                    <h2>Create topic</h2>
                    <div class="form-group">
                        <!-- <label for="inputEmail3" class="col-sm-2 control-label">Email</label> -->
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="summary" name="summary" placeholder="A brief clarification "/>
                        </div>
                    </div>
                    <div class="form-group">
                        <!-- <label for="inputPassword3" class="col-sm-2 control-label">Password</label> -->
                        <div class="col-sm-10">
                            <textarea title="Description" class="form-control" id="description" name="description" rows="3"> </textarea>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" id="create_submit">Submit</button>
            </div>
        </div>

    </div>

</div>
