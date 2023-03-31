<%-- 
    Document   : livestream
    Created on : Mar 23, 2023, 2:28:42 PM
    Author     : AnChuPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url var="url" value="/" />
<main id="live-streampage">
    <section class="blog_area section-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 mx-auto mb-5 mb-lg-0">
                    <div class="blog_left_sidebar">

                        <c:forEach items="${livestreams}" var="l">
                            <article class="blog_item">
                                <div class="blog_item_img">
                                    <img class="card-img rounded-0" src="${l.image}" alt="">
                                    <a href="#" class="blog_item_date">
                                        <h3>${l.startDate.getDate()}</h3>
                                        <p>Tháng ${l.startDate.getMonth() + 1}</p>
                                    </a>
                                </div>

                                <div class="blog_details">
                                    <a class="d-inline-block" href="<c:url value="/livestream/${l.id}" />">
                                        <h2>${l.title}</h2>
                                    </a>
                                    <p>${l.description}</p>
                                    <ul class="blog-info-link">
                                        <li><a href="#"><i class="fa fa-user"></i> Travel, Lifestyle</a></li>
                                        <li><a href="#"><i class="fa fa-comments"></i> 03 Comments</a></li>
                                    </ul>
                                </div>
                            </article>
                        </c:forEach> 

                    </div>
                </div>

            </div>
        </div>
    </section>
</main>
