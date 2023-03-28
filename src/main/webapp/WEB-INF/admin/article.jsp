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
        <form:form class="col-8 mx-auto" method="post" action="${action}" modelAttribute="article">
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
                <input type="file" class="form-control-file" id="file">
            </div>


            <c:choose>
                <c:when test="${not empty article.id}">
                    <button type="submit" class="btn btn-dark bg-dark update-btn">Update</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="btn btn-primary">Submit</button>
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
                                    <button class="btn btn-dark bg-dark col update-btn">Update</button>
                                </a>
                                <button class="btn col">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
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

