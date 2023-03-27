<%-- 
    Document   : enrolment-list
    Created on : Mar 27, 2023, 2:36:59 PM
    Author     : AnChuPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url  var="url" value="/" />
<!DOCTYPE html>

<main id="enrolment-list">
    <!-- About US Start -->
    <div class="about-area2 gray-bg pt-60 pb-60">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="whats-news-wrapper">
                        <!-- Heading & Nav Button -->
                        <div class="row justify-content-between align-items-end mb-15">
                            <div class="col-xl-4">
                                <div class="section-tittle mb-30">
                                    <h3>Whats New</h3>
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
                                            <c:forEach items="${articleType}" var="a">
                                                <div class="col-xl-6 col-lg-6 col-md-6">
                                                    <div class="whats-news-single mb-40 mb-40">
                                                        <div class="whates-img">
                                                            <img src="${a.image}" alt="">
                                                        </div>
                                                        <div class="whates-caption whates-caption2">
                                                            <h4><a href="#">Secretart for Economic Air
                                                                    plane that looks like</a></h4>
                                                            <span>by Alice cloe   -   Jun 19, 2020</span>
                                                            <p>Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Nav Card -->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <!-- Flow Socail -->
                    <div class="single-follow mb-45">
                        <div class="single-box">
                            <div class="follow-us d-flex align-items-center">
                                <div class="follow-social">
                                    <a href="#"><img src="${url}assets/img/news/icon-fb.png" alt=""></a>
                                </div>
                                <div class="follow-count">  
                                    <span>8,045</span>
                                    <p>Fans</p>
                                </div>
                            </div> 
                            <div class="follow-us d-flex align-items-center">
                                <div class="follow-social">
                                    <a href="#"><img src="${url}assets/img/news/icon-tw.png" alt=""></a>
                                </div>
                                <div class="follow-count">
                                    <span>8,045</span>
                                    <p>Fans</p>
                                </div>
                            </div>
                            <div class="follow-us d-flex align-items-center">
                                <div class="follow-social">
                                    <a href="#"><img src="${url}assets/img/news/icon-ins.png" alt=""></a>
                                </div>
                                <div class="follow-count">
                                    <span>8,045</span>
                                    <p>Fans</p>
                                </div>
                            </div>
                            <div class="follow-us d-flex align-items-center">
                                <div class="follow-social">
                                    <a href="#"><img src="${url}assets/img/news/icon-yo.png" alt=""></a>
                                </div>
                                <div class="follow-count">
                                    <span>8,045</span>
                                    <p>Fans</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- New Poster -->
                    <div class="news-poster d-none d-lg-block">
                        <img src="${url}assets/img/news/news_card.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- About US End -->
    <!--Start pagination -->
    <div class="pagination-area  gray-bg pb-45">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="single-wrap">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-start">
                                <li class="page-item"><a class="page-link" href="#">
                                        <!-- SVG icon -->
                                        <svg  xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="15px">
                                        <path fill-rule="evenodd"  fill="rgb(221, 221, 221)" d="M8.142,13.118 L6.973,14.135 L0.127,7.646 L0.127,6.623 L6.973,0.132 L8.087,1.153 L2.683,6.413 L23.309,6.413 L23.309,7.856 L2.683,7.856 L8.142,13.118 Z"/>
                                        </svg>
                                        </span></a></li>
                                <li class="page-item active"><a class="page-link" href="#">01</a></li>
                                <li class="page-item"><a class="page-link" href="#">02</a></li>
                                <li class="page-item"><a class="page-link" href="#">03</a></li>
                                <li class="page-item"><a class="page-link" href="#">
                                        <!-- SVG iocn -->
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="40px" height="15px">
                                        <path fill-rule="evenodd"  fill="rgb(255, 11, 11)" d="M31.112,13.118 L32.281,14.136 L39.127,7.646 L39.127,6.624 L32.281,0.132 L31.167,1.154 L36.571,6.413 L0.491,6.413 L0.491,7.857 L36.571,7.857 L31.112,13.118 Z"/>
                                        </svg>
                                        </span></a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End pagination  -->
</main>