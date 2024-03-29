<%-- 
    Document   : falcuty-detail
    Created on : Mar 23, 2023, 2:25:07 PM
    Author     : AnChuPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<main id="falcuty-detailpage">
    <div class="container my-5">
        <section>
            <h1>KHOA ${fn:toUpperCase(faculty.name)}</h1>
            <div class="d-flex align-items-lg-center">
                <i class ="fas fa-address-book fa-1x"></i>
                <h5 class="ml-3 mb-0">THÔNG TIN KHOA - NGÀNH</h5>
            </div>
            <div class="text-center text-uppercase">
                <h3>Giới thiệu khoa ${faculty.name}</h3>
            </div>
        </section>
        <section>
            <div class="container d-flex justify-content-center mt-5">
                <iframe width="600" height="300"
                        src="https://www.youtube.com/embed/${faculty.video}?autoplay=1&mute=0">
                </iframe>

            </div>
        </section>

        <section class="mt-5">
            <div class="d-flex justify-content-center">
                ${faculty.articleId.content}
            </div>
        </section>

        <section>
            <h5 class="text-uppercase text-center mt-3">Điểm trung bình 5 năm gần nhất của khoa</h5>
            <table class="table text-dark my-lg-3">
                <thead>
                <th>Major</th>
                    <c:forEach begin="0" end="4" var="index">
                    <th>${maxYear - index}</th>
                    </c:forEach>
                </thead>
                <tbody>
                    <c:forEach items="${majors}" var="major" varStatus="status">
                        <c:set value="${pointList[status.index]}" var="points"/>
                        <tr>
                            <th>${major.name}</th>
                                <c:forEach items="${points}" var="p">
                                    <c:choose>
                                        <c:when test="${p.point != null && p.point != ''}">
                                        <td>${p.point}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>--o--</td>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </tr>

                    </c:forEach>

                </tbody>
            </table>
        </section>
        <section class="text-center mt-lg-5">
            <a href="${faculty.url}" class="btn btn-info">Đến website của khoa ${faculty.name}</a>
        </section>

    </div>
</main>
