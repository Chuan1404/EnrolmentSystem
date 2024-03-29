<%-- 
    Document   : commnet
    Created on : Mar 26, 2023, 12:52:44 PM
    Author     : AnChuPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="comment-component gray-bg">
    <div class="container pb-5 pt-5">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <h3 class="text-center mb-5">
                        Comments
                    </h3>
                    <div class="row">
                        <div class="col-md-12" id="comment">
                            
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    <sec:authorize access="isAuthenticated()">
    <div class="container text-dark">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <c:set var="currentUser" value="${pageContext.request.session.getAttribute('currentUser')}" />
                    <div class="d-flex flex-start w-100">
                        <img class="rounded-circle shadow-1-strong mr-3"
                             src="${currentUser.avatar}" alt="avatar" width="65"
                             height="65" />
                        <div class="w-100">
                            <div class="form-outline">
                                <label class="form-label" for="comment-content">What is your view?</label>

                                <textarea class="form-control" id="comment-content" rows="2" name="comment-content"></textarea>
                            </div>
                            <div class="d-flex justify-content-between mt-3">
                                <c:url value="/api/article/${article.id}/comments" var="url"/>
                                <button type="button" class="btn btn-danger" onclick="addComment('${url}');">
                                    Send <i class="fas fa-long-arrow-alt-right ms-1"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </sec:authorize>


<c:url value="/assets/js" var="path"/>
<script src="${path}/pages/comments.js"></script>



