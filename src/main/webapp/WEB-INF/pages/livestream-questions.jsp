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
                <c:forEach begin="0" end="24" var="index">
                    <c:if test="${(activePage * 24 + index) < questions.size()}">
                        <c:set value="${questions[activePage * 24 + index]}" var="q"/>
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
                    </c:if>

                </c:forEach>
                <div class="pagination-area  gray-bg pb-45">
                    <div class="container">
                        <div class="row">
                            <div class="col-xl-12">
                                <div class="single-wrap">
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination justify-content-center">
                                            <li class="page-item"><a class="page-link" href="#">
                                                    <!-- SVG icon -->
                                                    <svg  xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="15px">
                                                    <path fill-rule="evenodd"  fill="rgb(221, 221, 221)" d="M8.142,13.118 L6.973,14.135 L0.127,7.646 L0.127,6.623 L6.973,0.132 L8.087,1.153 L2.683,6.413 L23.309,6.413 L23.309,7.856 L2.683,7.856 L8.142,13.118 Z"/>
                                                    </svg>
                                                    </a></li>

                                            <c:forEach begin="0" end="${pageLimit}" varStatus="loop">
                                                <c:choose>
                                                    <c:when test="${loop.index < 10}">
                                                        <li class="page-item <c:if test="${loop.index == activePage}">active</c:if>"><a class="page-link" href="?page=${loop.index}">${loop.index+1}</a></li>
                                                        </c:when>
                                                        <c:otherwise>
                                                        <li class="page-item <c:if test="${loop.index == activePage}">active</c:if>"><a class="page-link" href="?page=${loop.index}">${loop.index+1}</a></li>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            <li class="page-item"><a class="page-link" href="#">
                                                    <!-- SVG iocn -->
                                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="40px" height="15px">
                                                    <path fill-rule="evenodd"  fill="rgb(255, 11, 11)" d="M31.112,13.118 L32.281,14.136 L39.127,7.646 L39.127,6.624 L32.281,0.132 L31.167,1.154 L36.571,6.413 L0.491,6.413 L0.491,7.857 L36.571,7.857 L31.112,13.118 Z"/>
                                                    </svg>
                                                    </a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 
            </c:if>
        </div>
    </div>

</div>
