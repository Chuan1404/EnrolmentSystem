<%-- 
    Document   : falcuty
    Created on : Mar 23, 2023, 2:24:54 PM
    Author     : AnChuPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<main id="falcutypage">
    <div class="container my-5">
        <c:forEach items="${faculties}" begin="0" step="2" varStatus="status">
            <div class="row align-items-center text-center">
                <c:set value="${faculties[status.index]}" var="firstItem"/>
                <c:set value="${faculties[status.index + 1]}" var="secondItem"/>
                <c:url value="/faculty/${firstItem.id}" var="firstItemLink"/>
                <c:url value="/faculty/${secondItem.id}" var="secondItemLink"/>

                <div class="col-6 py-lg-5">
                    <a href="${firstItemLink}" class="text-dark h3">${firstItem.name}</a>
                    <div class="container-fluid mt-3">
                        <a href="${firstItemLink}">
                            <img src="${firstItem.articleId.image}" alt="alt"/>
                        </a>
                    </div>
                </div>
                <div class="col-6 py-lg-5">
                    <a href="${secondItemLink}" class="text-dark h3">${secondItem.name}</a>
                    <div class="container-fluid mt-3">
                        <a href="${secondItemLink}">
                            <img src="${secondItem.articleId.image}" alt="alt"/>
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</main>

