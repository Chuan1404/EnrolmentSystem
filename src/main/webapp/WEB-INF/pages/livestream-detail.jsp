<%-- 
    Document   : live-stream-detail
    Created on : Mar 23, 2023, 2:29:51 PM
    Author     : AnChuPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="url" value="/" />
<c:set var="date" value="<%=new java.util.Date()%>" />


<main id="live-stream-detailpage">
    <!--================Blog Area =================-->
    <section class="blog_area single-post-area section-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 mx-auto posts-list">
                    <div class="single-post text-center">
                        <div class="feature-img">
                            <c:choose>
                                <c:when test="${date gt livestream.startDate}">
                                    <iframe width="885" height="498" src="https://www.youtube.com/embed/${livestream.link}" title="ĐỪNG TRUNG THÀNH với công ty, đi làm để KIẾM TIỀN thôi!!! | Nguyễn Hữu Trí" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                                    </c:when>
                                    <c:otherwise>
                                    <img class="img-fluid w-100" src="${livestream.image}" alt="">
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="blog_details">
                            <h2>${livestream.title}
                            </h2>


                            <div class="quote-wrapper">
                                <div class="quotes">
                                    ${livestream.description}
                                </div>
                            </div>

                        </div>
                    </div>
                   
                    <sec:authorize access="isAuthenticated()">
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                            <div class="comment-form">
                                <h4>Leave a Question</h4>

                                <c:url value="/livestream/${livestream.id}/question" var="action"/>
                                <form:form class="form-contact comment_form" action="${action}" modelAttribute="question">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="form-group">
                                                <form:textarea class="form-control w-100" name="content" id="content" cols="30" rows="9"
                                                               placeholder="Write Comment" path="content"></form:textarea>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="button button-contactForm btn_1 boxed-btn">Gửi câu hỏi</button>
                                        </div>
                                </form:form>
                            </div>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_TUVAN')">
                            <c:url value="/livestream/${livestream.id}/questions" var="questions"/>
                            <button class="button button-contactForm boxed-btn"><a href="${questions}" class="text-danger">Đến xem câu hỏi</a></button>
                        </sec:authorize>
                    </sec:authorize>
                </div>


            </div>
        </div>
    </section>
</main>
