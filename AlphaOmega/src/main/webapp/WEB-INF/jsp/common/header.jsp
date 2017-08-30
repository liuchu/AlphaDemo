<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="resource/style/bootstrap.min.css" rel="stylesheet">

<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="resource/style/bootstrap-theme.min.css"></script>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resource/js/jquery-3.2.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resource/js/bootstrap.min.js"></script>

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
                            <li class="active">
                                <a href="#">Issues</a>
                            </li>
                            <li>
                                <a href="#">My activity </a>
                            </li>
                            <li>
                                <a href="#">Link</a>
                            </li>
                        </ul>

                        <shiro:authenticated>
                        <form class="navbar-form navbar-left" role="search">
                             <button type="submit" class="btn btn-default">Submit</button>
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

<!-- Modal container, pop-out when create -->