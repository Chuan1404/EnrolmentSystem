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
                                        <div class="reply-btn">
                                            <c:url value="/livestream/${q.livestreamId.id}/questions/${q.id}/answer" var="action"/>
                                            <a href="${action}" class="btn-reply text-uppercase">reply</a>
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
    <div class="row">
        <c:url value="/livestream/answer" var="sendAnswer"/>
        <form:form class="form-contact comment_form" action="${sendAnswer}" modelAttribute="answer" method="post">
            <div class="row">
                <h3>Trả lời câu hỏi</h3>
                <form:hidden path="livestreamId.id" value="${answer.livestreamId.id}"/>
                <form:hidden path="questionId.id" value="${answer.questionId.id}"/>
                <form:hidden path="userId.id" value="${answer.userId.id}"/>
                
                <div class="col-12">
                    <div class="form-group">
                        <form:textarea class="form-control w-100" name="content" id="content" cols="100" rows="9"
                                       placeholder="Write Comment" path="content"></form:textarea>
                    </div>
                </div>

            </div>
            <div class="form-group">
                <button type="submit" class="button button-contactForm boxed-btn">Gửi</button>
            </div>
        </form:form>
    </div>
</div>
