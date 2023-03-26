<%-- 
    Document   : article
    Created on : Mar 26, 2023, 3:01:08 PM
    Author     : AnChuPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                        <option value="${c}">${c.convertToString(c)}</option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <form:input class="form-control" path="description" placeholder="Input description here" />
            </div>
            <div class="form-group">
                <label for="content">Content</label>
                <!--<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>-->
                <form:textarea path="content" class="form-control" id="content" rows="3"></form:textarea>
                </div>
<!--                <div class="form-group">
                    <label for="file">Image</label>
                    <input type="file" class="form-control-file" id="file">
                </div>-->


                <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</main>
        
<script src="https://cdn.tiny.cloud/1/hkiir3w66qsfdv856ttemmqztxxfkcpgkr1ebc69har0t88n/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>

<script>
    tinymce.init({
        selector: 'textarea#content', // chon textarea de sua
        plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tableofcontents footnotes mergetags autocorrect typography inlinecss',
        toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | emoticons charmap | removeformat'
    });
</script>

