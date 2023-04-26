<%-- 
    Document   : base
    Created on : Mar 20, 2023, 12:33:26 PM
    Author     : AnChuPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title><tiles:insertAttribute name="title" /></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--<link rel="manifest" href="site.webmanifest">-->
        <!--<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">-->

        <!-- CSS here -->
        <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/css/owl.carousel.min.css" />">
        <link rel="stylesheet" href="<c:url value="/css/ticker-style.css" />">
        <link rel="stylesheet" href="<c:url value="/css/flaticon.css" />">
        <link rel="stylesheet" href="<c:url value="/css/slicknav.css" />">
        <link rel="stylesheet" href="<c:url value="/css/animate.min.css" />">
        <link rel="stylesheet" href="<c:url value="/css/magnific-popup.css" />">
        <link rel="stylesheet" href="<c:url value="/css/fontawesome-all.min.css" />">
        <link rel="stylesheet" href="<c:url value="/css/themify-icons.css" />">
        <link rel="stylesheet" href="<c:url value="/css/slick.css" />">
        <link rel="stylesheet" href="<c:url value="/css/nice-select.css" />">
        <link rel="stylesheet" href="<c:url value="/css/comment.css" />">
        <link rel="stylesheet" href="<c:url value="/css/chatbox.css" />">
        <link rel="stylesheet" href="<c:url value="/css/style.css" />">
        <script src="https://cdn.jsdelivr.net/sockjs/1.5.1/sockjs.min.js"></script>
        <script src="https://cdn.jsdelivr.net/stomp.js/2.3.4/stomp.min.js"></script>
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="content" />
        <tiles:insertAttribute name="comment" />
        <tiles:insertAttribute name="footer" />
        <tiles:insertAttribute name="texteditor"/>


        <div id="chatbox-icon"></div>
        <div id="chatbox-popup" class="hidden">
            <div class="card" id="chat1" style="border-radius: 15px;">
                <div
                    class="card-header d-flex justify-content-between align-items-center p-3 bg-info text-white border-bottom-0"
                    style="border-top-left-radius: 15px; border-top-right-radius: 15px;">
                    <i class="fas fa-angle-left"></i>
                    <p class="mb-0 fw-bold">Live chat</p>
                    <i class="close-icon fas fa-times"></i>
                </div>
                <div class="card-body">

                    <div class="d-flex flex-row justify-content-start mb-4">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                             alt="avatar 1" style="width: 45px; height: 100%;">
                        <div class="p-3 ms-3" style="border-radius: 15px; background-color: rgba(57, 192, 237,.2);">
                            <p class="small mb-0">Hello and thank you for visiting MDBootstrap. Please click the video
                                below.</p>
                        </div>
                    </div>

                    <div class="d-flex flex-row justify-content-end mb-4">
                        <div class="p-3 me-3 border" style="border-radius: 15px; background-color: #fbfbfb;">
                            <p class="small mb-0">Thank you, I really like your product.</p>
                        </div>
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                             alt="avatar 1" style="width: 45px; height: 100%;">
                    </div>

                    <div class="d-flex flex-row justify-content-start mb-4">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                             alt="avatar 1" style="width: 45px; height: 100%;">
                        <div class="ms-3" style="border-radius: 15px;">
                            <div class="bg-image">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/screenshot1.webp"
                                     style="border-radius: 15px;" alt="video">
                                <a href="#!">
                                    <div class="mask"></div>
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="d-flex flex-row justify-content-start mb-4">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                             alt="avatar 1" style="width: 45px; height: 100%;">
                        <div class="p-3 ms-3" style="border-radius: 15px; background-color: rgba(57, 192, 237,.2);">
                            <p class="small mb-0">...</p>
                        </div>
                    </div>

                    <div class="form-outline">
                        <textarea id="message" class="form-control" id="textAreaExample" rows="4"></textarea>
                        <label class="form-label" for="textAreaExample">Type your message</label>
                    </div>
                    <button onclick="sendMessage()" class="btn btn-primary">Send</button>
                </div>
            </div>
        </div>

    </body>

    <!-- JS here -->

    <c:url var="url" value="/assets/js" />

    <script src="${url}/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="${url}/vendor/jquery-1.12.4.min.js"></script>
    <script src="${url}/popper.min.js"></script>
    <script src="${url}/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="${url}/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="${url}/owl.carousel.min.js"></script>
    <script src="${url}/slick.min.js"></script>
    <!-- Date Picker -->
    <script src="${url}/gijgo.min.js"></script>
    <!-- One Page, Animated-HeadLin -->
    <script src="${url}/wow.min.js"></script>
    <script src="${url}/animated.headline.js"></script>
    <script src="${url}/jquery.magnific-popup.js"></script>

    <!-- Scrollup, nice-select, sticky -->
    <script src="${url}/jquery.scrollUp.min.js"></script>
    <script src="${url}/jquery.nice-select.min.js"></script>
    <script src="${url}/jquery.sticky.js"></script>

    <!-- contact js -->
    <script src="${url}/contact.js"></script>
    <script src="${url}/jquery.form.js"></script>
    <script src="${url}/jquery.validate.min.js"></script>
    <script src="${url}/mail-script.js"></script>
    <script src="${url}/jquery.ajaxchimp.min.js"></script>

    <!-- Jquery Plugins, main Jquery -->	
    <script src="${url}/plugins.js"></script>
    <script src="${url}/chatbox.js"></script>
    <script src="${url}/main.js"></script>

</html>