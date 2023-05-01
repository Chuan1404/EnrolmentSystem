<%-- 
    Document   : enrolment
    Created on : Mar 23, 2023, 3:04:26 PM
    Author     : AnChuPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<main id="enrolment">
    <!-- Whats New Start -->
    <section class="whats-news-area pt-50 pb-20 gray-bg">
        <div class="container">


            <div class="row">
                <c:forEach items="${articleList}" var="article">

                    <div class="col-lg-10 m-auto">
                        <div class="whats-news-wrapper">
                            <!-- Heading & Nav Button -->
                            <div class="row justify-content-between align-items-end mb-15">
                                <div class="col-12">
                                    <div class="section-tittle mb-30">
                                        <h3 class="text-center">${article.title}</h3>
                                    </div>
                                </div>
                            </div>
                            <!-- Tab content -->
                            <div class="row">
                                <div class="col-12">
                                    <!-- Nav Card -->
                                    <div class="tab-content" id="nav-tabContent">
                                        <!-- card one -->
                                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">       
                                            <div class="row">
                                                <!-- Left Details Caption -->
                                                <div class="col-xl-6 col-lg-12">
                                                    <div class="whats-news-single mb-40 mb-40">
                                                        <div class="whates-img">
                                                            <img src="${article.data[0].image}" alt="a">
                                                        </div>
                                                        <div class="whates-caption">
                                                            <h4><a href="${article.data[0].id}"> ${article.data[0].title}</a></h4>

                                                            <p>${article.data[0].description}</p>

                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xl-6 col-lg-12">
                                                    <div class="row">
                                                        <c:forEach items="${article.data}" var="item" begin="1">
                                                            <!-- single -->
                                                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-10">
                                                                <div class="whats-right-single mb-20">
                                                                    <div class="whats-right-img">
                                                                        <img src="${item.image}" alt="">
                                                                    </div>
                                                                    <div class="whats-right-cap">
                                                                        <span class="colorb">${item.articleType}</span>
                                                                        <h4><a href="${item.id}">${item.title}</a></h4>

                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-xl-12 col-lg-6 col-md-6 col-sm-10 text-right">
                                                            <a href="<c:url value="/enrolment/type/${article.data[0].articleType}" />" style="color: #000000">Xem thêm >></a>
                                                        </div>
                                                    </div>            
                                                </div>

                                                <!-- Right single caption -->

                                            </div>
                                        </div>
                                    </div>
                                    <!-- End Nav Card -->
                                </div>
                            </div>
                        </div>
                        <!-- Banner -->
                        <div class="banner-one mt-20 mb-30">
                            <img src="assets/img/gallery/body_card1.png" alt="">
                        </div>
                    </div>

                   
                </c:forEach>

            </div>


        </div>
    </section>
</main>

