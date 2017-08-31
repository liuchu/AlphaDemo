<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="profile.profile"/></title>
</head>


<body>

<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>
<script src="resource/js/profile.js"></script>

<div class="container">
    <div class="row clearfix" style="margin-top: 10%">
        <div class="col-md-6 column">
            <label><spring:message code="profile.personal_profile"/></label>
        </div>
        <div class="col-md-6 column">
            <label><spring:message code="profile.personal_setting"/></label>
            <select class="form-control" id="select_language">
                <option>English</option>
                <option>中文</option>
            </select>
            <button type="button" class="btn btn-default">
                <a id="select_language_submit"><spring:message code="profile.change"/> </a>
            </button>
            <%--<p> 当前语言: ${pageContext.response.locale } </p>--%>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>

</body>
</html>
