<%-- 
Document   : header
Created on : Mar 20, 2023, 12:35:34 PM
Author     : AnChuPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<c:url var="url" value="/" />
<!DOCTYPE html>

<header>
    <!-- Header Start -->
    <div class="header-area">
        <div class="main-header ">
            <div class="header-mid gray-bg">
                <div class="container">
                    <div class="row d-flex align-items-center">
                        <!-- Logo -->
                        <div class="col-xl-3 col-lg-3 col-md-3 d-none d-md-block">
                            <div class="logo">
                                <a href="${url}"><img src="${url}assets/img/logo/logo.png" alt=""></a>
                            </div>
                        </div>
                        <div class="col-xl-9 col-lg-9 col-md-9">
                            <div class="header-banner f-right ">
                                <img src="${url}assets/img/gallery/header_card.png" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header-bottom header-sticky">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-xl-8 col-lg-8 col-md-12 header-flex">
                            <!-- sticky -->
                            <div class="sticky-logo">
                                <a href="index.html"><img src="${url}assets/img/logo/logo.png" alt=""></a>
                            </div>
                            <!-- Main-menu -->
                            <div class="main-menu d-none d-md-block">
                                <nav>                  
                                    <ul id="navigation">
                                        <li><a href="/">TRANG CHỦ</a></li>

                                        <li><a href="${url}enrolment/">THÔNG TIN TUYỂN SINH</a></li>
                                        <li><a href="${url}faculty/">THÔNG TIN KHOA</a></li>
                                        <li><a href="${url}livestream/">Thông tin Livestream</a></li>
                                        <!--                                        <li><a href="#">Pages</a>
                                                                                    <ul class="submenu">
                                                                                        <li><a href="blog.html">Blog</a></li>
                                                                                        <li><a href="blog_details.html">Blog Details</a></li>
                                                                                        <li><a href="elements.html">Element</a></li>
                                                                                    </ul>
                                                                                </li>-->

                                    </ul>
                                </nav>
                            </div>
                        </div>             
                        <div class="col-xl-4 col-lg-4 col-md-4">
                            <div class="header-right f-right d-none d-lg-block">
                                <!-- Heder social -->
                                <ul class="header-social">    


                                    <c:choose>
                                        <c:when test="${pageContext.request.userPrincipal.name != null}">
                                            <li> <a href="#">Chào ${pageContext.request.userPrincipal.name}</a></li>
                                            <li> <a href="<c:url value="/logout" />">Đăng xuất</a></li>
                                            </c:when>
                                            <c:otherwise>
                                            <li> <a href="<c:url value="/auth/login" />">Đăng nhập</a></li>
                                            <li> <a href="<c:url value="/auth/register" />">Đăng kí</a></li>
                                            </c:otherwise>
                                        </c:choose>
                                </ul>

                            </div>
                        </div>
                        <!-- Mobile Menu -->
                        <div class="col-12">
                            <div class="mobile_menu d-block d-md-none"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->
</header>