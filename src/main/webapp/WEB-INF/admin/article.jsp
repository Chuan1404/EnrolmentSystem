<%-- 
    Document   : article
    Created on : Mar 26, 2023, 3:01:08 PM
    Author     : AnChuPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="url" value="/admin/article/" />

<main class="admin-article">
    <div class="container py-5">
        <c:url value="/admin/article/" var="action"/>
        <form:form class="col-8 mx-auto" method="post" action="${action}" modelAttribute="article" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title">Title</label>
                <form:input path="title" class="form-control" placeholder="Input title here" />
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Article Type</label>
                <form:select class="form-control w-100" path="articleType">
                    <c:forEach items="${articleType}" var="c">
                        <option value="${c}" <c:if test="${c == article.articleType}">selected</c:if>>${c.convertToString(c)}</option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <form:input class="form-control" path="description" placeholder="Input description here" />
            </div>
            <div class="form-group">
                <label for="content">Content</label>
                <form:textarea path="content" class="form-control" id="content" rows="3"  />
            </div>

            <c:if test="${not empty article.image}">
                <div class="form-group input-group mb-3">
                    <img width = "120" src="${article.image}" />
                </div>
            </c:if>
            <div class="form-group input-group mb-3">
                <label for="file">Image</label>
                <form:input type="file" path="file" class="form-control-file" id="file" />
            </div>


            <c:choose>
                <c:when test="${not empty article.title}">
                    <button type="submit" class="genric-btn primary update-btn">Update</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="genric-btn danger e-large">Submit</button>
                </c:otherwise>
            </c:choose>
        </form:form>
    </div>

    <c:if test="${not empty articles}">
        <div class="container-fluid">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Image</th>
                        <th scope="col">Title</th>
                        <th scope="col">Description</th>
                        <th scope="col">Type</th>
                        <th scope="col">Create date</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${articles}" var="a" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>
                                <image src="${a.image}" width="120" />
                            </td>
                            <td>${a.title}</td>
                            <td>${a.description}</td>
                            <td>${a.articleType}</td>
                            <td>${a.createdDate}</td>
                            
                            <td class="d-flex">
                                <a href="${url}${a.id}">
                                    <button class="genric-btn primary circle update-btn">Update</button>
                                </a>

                                <button class="genric-btn danger circle update-btn col" onclick="deleteArticle('<c:url value="/api/article/${a.id}" />')">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </c:if>
    <c:if test="${not empty totalPage}">
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

                                    <c:forEach begin="1" end="${totalPage}" varStatus="loop">
                                        <c:choose>
                                            <c:when test="${loop.index < 10}">
                                                <li class="page-item <c:if test="${loop.index == currentPage}">active</c:if>"><a class="page-link" href="?page=${loop.index}">0${loop.index}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                <li class="page-item <c:if test="${loop.index == currentPage}">active</c:if>"><a class="page-link" href="?page=${loop.index}">${loop.index}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
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
    </c:if>

</main>
<style>
    .update-btn::before {
        background: #2b2f32;
    }
</style>
<script src="https://cdn.tiny.cloud/1/hkiir3w66qsfdv856ttemmqztxxfkcpgkr1ebc69har0t88n/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>

<script>
                                    tinymce.init({
                                        selector: 'textarea#content', // chon textarea de sua
                                        plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tableofcontents footnotes mergetags autocorrect typography inlinecss',
                                        toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | emoticons charmap | removeformat'
                                    });
</script>

<c:url var="url" value="/assets/js" />
<script src="${url}/pages/article.js" />