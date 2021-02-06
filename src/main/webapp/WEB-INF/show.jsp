<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/partials/head.jsp" %>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<main class="container">

    <div class="card">

        <div class="card-body">
            <div class="row">
                <div class="col">
                    <h3><c:out value="${user.name}"/> details...</h3>
                    <p>Email: <c:out value="${user.email}"/></p>
                </div>
                <div class="col">
                    <h3><c: value="${user.name}"/> ads...</h3>
                    <ul class="list-group">
                        <c:forEach var="fad" items="${ads}">
                            <li class="list-group-item">
                                <a href="${pageContext.request.contextPath}/ads/show?id=<c:out value="${ad.id}"/>"><c:
                                        value="${ad.title}"/></a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

    </div>
</main>

