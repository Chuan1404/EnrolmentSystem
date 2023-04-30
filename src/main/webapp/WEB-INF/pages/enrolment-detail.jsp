<%-- 
    Document   : artical-detail
    Created on : Mar 23, 2023, 2:23:50 PM
    Author     : AnChuPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="url" value="/" />


<style>
    #enrolment-detailpage .about-img img {
        max-width: 80%;
        object-fit: contain;
    }
    .article-content img {
        max-width: 100%;
        object-fit: cover
    }
</style>
<main id="enrolment-detailpage">
    <!-- About US Start -->
    <div class="about-area2 gray-bg pt-60 pb-60">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 m-auto">
                    <!-- Trending Tittle -->
                    <div class="about-right mb-90">
                        <div class="about-img d-flex justify-content-center">
                            <img src="${article.image}" alt="">
                        </div>
                        <div class="heading-news mb-30 pt-30">
                            <h3>${article.title}</h3>
                        </div>
                        <div class="about-prea article-content">
                            ${article.content}
                        </div>
                    </div>
                    <!-- From -->
                </div>
            </div>
        </div>
    </div>
    <!-- About US End -->

</main>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<c:url value="/api/article/${article.id}/comments" var="url"/>
<c:url value="/assets/js" var="path"/>
<script src="${path}/pages/comments.js"></script>
<script>
    window.onload = function () {
        loadComments('${url}');
    };
</script>