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
                <div class="col-lg-8">
                    <div class="whats-news-wrapper">
                        <!-- Heading & Nav Button -->
                        <div class="row justify-content-between align-items-end mb-15">
                            <div class="col-12">
                                <div class="section-tittle mb-30">
                                    <h3 class="text-center">THÔNG TIN TUYỂN SINH ĐẠI HỌC CHÍNH QUY</h3>
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
                                                        <img src="${articles[0].image}" alt="a">
                                                    </div>
                                                    <div class="whates-caption">
                                                        <!--<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like</a></h4>-->
                                                        ${articles[0].title}
                                                        <span>by Alice cloe   -   Jun 19, 2020</span>
                                                        <!--<p>Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.</p>-->
                                                         ${articles[0].description}
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-6 col-lg-12">
                                                <div class="row">
                                                    <% for (int i = 1; i < 5; i++) {%>
                                                    <!-- single -->
                                                    <div class="col-xl-12 col-lg-6 col-md-6 col-sm-10">
                                                        <div class="whats-right-single mb-20">
                                                            <div class="whats-right-img">
                                                                <img src="${articles.get(i).image}" alt="">
                                                            </div>
                                                            <div class="whats-right-cap">
                                                                <span class="colorb">FASHION</span>
                                                                <!--<h4><a href="latest_news.html">Portrait of group of friends ting eat. market in.</a></h4>-->
                                                                ${articles.get(i).title}
                                                                <p>Jun 19, 2020</p> 
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <% }%>

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

                <div class="col-lg-4">
                    <!-- Most Recent Area -->
                    <div class="most-recent-area">
                        <!-- Section Tittle -->
                        <div class="small-tittle mb-20">
                            <h4>Most Recent</h4>
                        </div>
                        <!-- Details -->
                        <div class="most-recent mb-40">
                            <div class="most-recent-img">
                                <img src="<c:url value="/assets/img/gallery/most_recent.png" />" alt="">
                                <div class="most-recent-cap">
                                    <span class="bgbeg">Vogue</span>
                                    <h4><a href="latest_news.html">What to Wear: 9+ Cute Work <br>
                                            Outfits to Wear This.</a></h4>
                                    <p>Jhon  |  2 hours ago</p>
                                </div>
                            </div>
                        </div>
                        <!-- Single -->
                        <div class="most-recent-single">
                            <div class="most-recent-images">
                                <img src="<c:url value="/assets/img/gallery/most_recent1.png" />" alt="">
                            </div>
                            <div class="most-recent-capt">
                                <h4><a href="latest_news.html">Scarlett’s disappointment at latest accolade</a></h4>
                                <p>Jhon  |  2 hours ago</p>
                            </div>
                        </div>
                        <!-- Single -->
                        <div class="most-recent-single">
                            <div class="most-recent-images">
                                <img src="<c:url value="/assets/img/gallery/most_recent2.png" />" alt="">
                            </div>
                            <div class="most-recent-capt">
                                <h4><a href="latest_news.html">Most Beautiful Things to Do in Sidney with Your BF</a></h4>
                                <p>Jhon  |  3 hours ago</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </section>
</main>

