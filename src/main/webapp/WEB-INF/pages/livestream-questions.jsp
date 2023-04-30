<%-- 
    Document   : livestream-questions
    Created on : Apr 29, 2023, 6:49:44 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<div class="container">
    <div class="row">
        <h2 class="text-center text-info w-100">Questions</h2>
        <div class="comments-area">
            <h4>${questions.size()} Questions</h4>
            <c:if test="${not empty questions}">
                <c:forEach items="${questions}" var="q">
                    <div class="comment-list">
                        <div class="single-comment justify-content-between d-flex">
                            <div class="user justify-content-between d-flex">
                                <div class="thumb">
                                    <img src="${q.userId.avatar}" alt="${q.userId.name}">
                                </div>
                                <div class="desc">
                                    <p class="comment">
                                        ${q.content}
                                    </p>
                                    <div class="d-flex justify-content-between">
                                        <div class="d-flex align-items-center">
                                            <h5>
                                                <a href="#">${q.userId.name}</a>
                                            </h5>
                                            <!--<p class="date">December 4, 2017 at 3:12 pm </p>-->
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
    
</div>
