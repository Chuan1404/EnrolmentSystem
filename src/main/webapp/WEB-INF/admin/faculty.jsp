<%-- 
    Document   : faculty
    Created on : Apr 4, 2023, 2:13:33 PM
    Author     : jackc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<main id="admin-faculty">
    <div class="container-fluid py-lg-5">
        <c:url value="/admin/faculties/" var="action"/>
        <form:form class="col-8 mx-auto" action="${action}" method="post" modelAttribute="faculty">

            

            <form:errors path="video" cssClass="text-danger"/>
            <div class="form-group">
                <label for="video">Video</label>
                <form:input path="video" class="form-control" placeholder="Enter faculty's video here..."/>
            </div>
            
            <form:errors path="url" cssClass="text-danger"/>
            <div class="form-group">
                <label for="url">URL</label>
                <form:input path="url" class="form-control" placeholder="Enter faculty's website link here..."/>
            </div>
            <form:errors path="name" cssClass="text-danger"/>
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="name" class="form-control" placeholder="Enter faculty's name here..."/>
            </div>
            <c:choose>
                <c:when test="${faculty.id == null}">
                    <button type="submit" class="genric-btn primary e-large">Submit</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="genric-btn danger e-large">Update</button>
                </c:otherwise>
            </c:choose>

        </form:form>
    </div>
    <c:if test="${not empty faculties}">
        <table class="table text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Video</th>
                    <th scope="col">Url</th>
                    <th scope="col">Article</th>
                    <th scope="col"></th>
                </tr>
            <tbody>
                <c:forEach items="${faculties}" var="f" varStatus="status">
                    <tr>
                        <td class="align-middle">${status.index + 1}</td>
                        <td class="align-middle">${f.name}</td>
                        <td class="align-middle"><iframe width="300" height="200"
                                                         src="https://www.youtube.com/embed/${f.video}?autoplay=&mute=0&controls=1">
                            </iframe></td>
                        <td class="align-middle"><a href="${f.url}" class="text-dark" target="blank">Trang web khoa ${f.name}</a></td>
                        <td class="align-middle">
                            <a href="<c:url value="/admin/article/${f.articleId.id}"/>"
                               <button class="genric-btn info e-large">Cập nhật bài viết</button>
                            </a>
                        </td>
                        <td class="align-middle">
                            <a href="<c:url value="/admin/faculties/${f.id}"/>">
                                <button class="genric-btn primary circle update-btn">Update</button>
                            </a>

                            <button class="genric-btn danger circle update-btn" onclick="deleteFaculty('<c:url value="/api/faculties/${f.id}"/>')">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>

            </thead>
        </table>
    </c:if>
</main>

<c:url var="url" value="/assets/js" />
<script src="${url}/pages/faculties.js" />
