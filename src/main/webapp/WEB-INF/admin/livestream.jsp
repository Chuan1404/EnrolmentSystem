<%-- 
    Document   : livestream
    Created on : Apr 1, 2023, 10:05:58 AM
    Author     : AnChuPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<main id="admin-livestream">
    <div class="container-fluid py-5">
        <c:url value="/admin/livestream/" var="action"/>
        <form:form class="col-8 mx-auto" method="post" action="${action}" modelAttribute="livestream" enctype="multipart/form-data">

            <form:errors path="title" cssClass="text-danger" />
            <div class="form-group">
                <label for="title">Title</label>
                <form:input path="title" class="form-control" placeholder="Input title here" />
            </div>

            <form:errors path="description" cssClass="text-danger" />
            <div class="form-group">
                <label for="description">Description</label>
                <form:input class="form-control" path="description" placeholder="Input description here" />
            </div>

            <form:errors path="link" cssClass="text-danger" />
            <div class="form-group">
                <label for="link">Link</label>
                <form:input class="form-control" path="link" placeholder="Input link here" />
            </div>

            <!--livestream date-->
            <c:set var="date" value="<%=new java.util.Date()%>" />
            <form:errors path="startDate" cssClass="text-danger" />
            <div class="form-group">
                <label for="startDate">Ngày livestream</label>
                <form:input path="startDate" min="${date.toLocaleString()}" class="form-control" type="datetime-local" />
            </div>

            <form:errors path="duration" cssClass="text-danger" />
            <div class="form-group">
                <label for="duration">Thời lượng livestream (phút)</label>
                <form:input path="duration" class="form-control" type="number" disabled="true"/>
            </div>

            <form:errors path="startQuestionTime" cssClass="text-danger" />
            <div class="form-group">
                <label for="startQuestionTime">Giờ bắt đầu đặt câu hỏi (trong lúc livestream)</label>
                <form:input path="startQuestionTime" class="form-control" type="time" disabled="true"/>
            </div>

            <form:errors path="questionDuration" cssClass="text-danger" />
            <div class="form-group">
                <label for="questionDuration">Giờ kết thúc đặt câu hỏi (trong lúc livestream)</label>
                <form:input path="questionDuration" class="form-control" type="number" disabled="true"/>
            </div>

            <div class="form-group">
                <label for="userId" class="label">Tư vấn viên phụ trách</label>
                <form:select path="userId" class="form-control w-100" id="userId" name="userId">
                    <c:forEach items="${users}" var="u">
                        <c:choose>
                            <c:when test="${livestream.userId.id == u.id}">
                                <option value="${u.id}" selected>${u.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${u.id}">${u.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>>
                </form:select>
            </div>

            <c:if test="${not empty livestream.image}">
                <div class="form-group input-group mb-3">
                    <img width = "120" src="${livestream.image}" />
                </div>
            </c:if>

            <c:if test="${empty livestream.id}">
                <form:errors path="file" cssClass="text-danger" />
            </c:if>
            <div class="form-group input-group mb-3">
                <label for="file">Image</label>
                <form:input type="file" path="file" class="form-control-file" id="file" />
            </div>


            <c:choose>
                <c:when test="${livestream.id != null}">
                    <form:hidden path="id" />
                    <form:hidden path="image" />
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
                            <td>${l.duration}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd 'at' HH:mm" value="${l.startDate}" /></td>
                            <td>${l.startQuestionTime} ${l.questionDuration}</td>
                            <td class="d-flex">
                                <a href="<c:url value="/admin/livestream/${l.id}" />">
                                    <button class="genric-btn primary circle update-btn">Update</button>
                                </a>

                                <button class="genric-btn danger circle" onclick="deleteLivestream('<c:url value="/api/livestream/${l.id}" />')">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </c:if>
</main>

<c:url var="url" value="/assets/js" />
<script src="${url}/pages/livestream.js" />
