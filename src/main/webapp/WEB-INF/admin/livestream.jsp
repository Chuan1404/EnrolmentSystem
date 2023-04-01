<%-- 
    Document   : livestream
    Created on : Apr 1, 2023, 10:05:58 AM
    Author     : AnChuPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<main id="admin-livestream">
    <div class="container py-5">
        <c:url value="/admin/livestream/" var="action"/>
        <form:form class="col-8 mx-auto" method="post" action="${action}" modelAttribute="livestream" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title">Title</label>
                <form:input path="title" class="form-control" placeholder="Input title here" />
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <form:input class="form-control" path="description" placeholder="Input description here" />
            </div>
            <div class="form-group">
                <label for="link">Link</label>
                <form:input class="form-control" path="link" placeholder="Input link here" />
            </div>
            <div class="form-group">
                <label for="link">Ngày livestream</label>
                <form:input path="startDate" class="form-control" type="date" />
            </div>
            <div class="form-group">
                <label for="link">Giờ livestream</label>
                <form:input path="startTime" class="form-control" type="time" />
            </div>
            <div class="form-group">
                <label for="link">Thời lượng livestream (phút)</label>
                <form:input path="duration" class="form-control" type="number" />
            </div>
            <div class="form-group">
                <label for="link">Giờ bắt đầu đặt câu hỏi (trong lúc livestream)</label>
                <form:input path="startQuestionTime" class="form-control" type="time" />
            </div>
            <div class="form-group">
                <label for="link">Giờ kết thúc đặt câu hỏi (trong lúc livestream)</label>
                <form:input path="endQuestionTime" class="form-control" type="time" />
            </div>

            <c:if test="${not empty livestream.image}">
                <div class="form-group input-group mb-3">
                    <img width = "120" src="${livestream.image}" />
                </div>
            </c:if>
            <div class="form-group input-group mb-3">
                <label for="file">Image</label>
                <form:input type="file" path="file" class="form-control-file" id="file" />
            </div>


            <c:choose>
                <c:when test="${not empty livestream.title}">
                    <button type="submit" class="genric-btn primary e-large update-btn">Update</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="genric-btn danger e-large">Submit</button>
                </c:otherwise>
            </c:choose>
        </form:form>
    </div>

    <c:if test="${not empty livestreams}">
        <div class="container-fluid">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Image</th>
                        <th scope="col">Title</th>
                        <th scope="col">Description</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Start date - time</th>
                        <th scope="col">Start/End question time</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${livestreams}" var="l" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>
                                <image src="${l.image}" width="120" />
                            </td>
                            <td>${l.title}</td>
                            <td>${l.description}</td>
                            <td>${l.duration}</td>
                            <td>${l.startDate} ${l.startTime}</td>
                            <td>${l.startQuestionTime} ${l.endQuestionTime}</td>
                            <td class="d-flex">
                                <a href="${url}${l.id}">
                                    <button class="genric-btn primary circle update-btn">Update</button>
                                </a>

                                <button class="genric-btn danger circle" onclick="deleteArticle('<c:url value="/api/article/${a.id}" />')">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </c:if>
</main>
