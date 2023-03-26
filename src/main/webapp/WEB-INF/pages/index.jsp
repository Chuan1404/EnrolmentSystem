<%-- 
    Document   : index
    Created on : Mar 20, 2023, 12:47:21 AM
    Author     : AnChuPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<main id="homepage">
    <!-- Trending Area Start -->
    <div class="trending-area fix pt-25 gray-bg">
        <div class="container">
            <div class="trending-main">
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Trending Top -->
                        <div class="slider-active">
                            <c:forEach items="${images}" var="img">
                                <!-- Single -->
                                <div class="single-slider">
                                    <div class="trending-top mb-30">
                                        <div class="trend-top-img">
                                            <img src="${img.url}" alt="">
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <section>
        ${home.content}
    </section>
    <!--Recent Articles End -->
    <!-- Start Video Area -->
    <div class="youtube-area video-padding d-none d-sm-block">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="video-items-active">
                        <div class="video-items text-center">
                            <c:url value="https://www.youtube.com/embed/${home.video}?loop=1&autoplay=1&mute=1&controls=0" var="video"/>
                            <iframe style="width:100%;aspect-ratio:16 / 9;"
                            src="${video}">
                            </iframe>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div> 

</main>

<!-- Search model Begin 
<div class="search-model-box">
    <div class="d-flex align-items-center h-100 justify-content-center">
        <div class="search-close-btn">+</div>
        <form class="search-model-form">
            <input type="text" id="search-input" placeholder="Searching key.....">
        </form>
    </div>
</div>
 Search model end -->