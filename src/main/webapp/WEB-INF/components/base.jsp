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
        <link rel="stylesheet" href="<c:url value="/css/style.css" />">

    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="content" />
        <tiles:insertAttribute name="footer" />
    </body>
    
    <!-- JS here -->

    <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="./assets/js/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="./assets/js/owl.carousel.min.js"></script>
    <script src="./assets/js/slick.min.js"></script>
    <!-- Date Picker -->
    <script src="./assets/js/gijgo.min.js"></script>
    <!-- One Page, Animated-HeadLin -->
    <script src="./assets/js/wow.min.js"></script>
    <script src="./assets/js/animated.headline.js"></script>
    <script src="./assets/js/jquery.magnific-popup.js"></script>

    <!-- Scrollup, nice-select, sticky -->
    <script src="./assets/js/jquery.scrollUp.min.js"></script>
    <script src="./assets/js/jquery.nice-select.min.js"></script>
    <script src="./assets/js/jquery.sticky.js"></script>
    
    <!-- contact js -->
    <script src="./assets/js/contact.js"></script>
    <script src="./assets/js/jquery.form.js"></script>
    <script src="./assets/js/jquery.validate.min.js"></script>
    <script src="./assets/js/mail-script.js"></script>
    <script src="./assets/js/jquery.ajaxchimp.min.js"></script>
    
    <!-- Jquery Plugins, main Jquery -->	
    <script src="./assets/js/plugins.js"></script>
    <script src="./assets/js/main.js"></script>
</html>
