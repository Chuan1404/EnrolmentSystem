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
           
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="name" class="form-control" placeholder="Enter faculty's name here..."/>
            </div>
            
            <div class="form-group">
                <label for="video">Video</label>
                <form:input path="video" class="form-control" placeholder="Enter faculty's video here..."/>
            </div>
            <div class="form-group">
                <label for="url">URL</label>
                <form:input path="url" class="form-control" placeholder="Enter faculty's website link here..."/>
            </div>
                <c:choose>
                    <c:when test="${faculty.id != null}">
                        <form:hidden path="id"/>
                        <button type="submit" class="genric-btn primary e-large">Submit</button>
                    </c:when>
                </c:choose>
            <button type="submit" class="genric-btn danger e-large">Submit</button>
        </form:form>
    </div>
</main>
