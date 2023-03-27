<%-- 
    Document   : homepage
    Created on : Mar 27, 2023, 8:55:29 PM
    Author     : jackc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<main class="admin-homepage">

    <h1 class="text-center">ADMIN HOMEPAGE</h1>
    <div class="container py-5">
        <c:url value="/admin/homepage/update" var="action"/>
        <form:form class="col-8 mx-auto" method="post" action="${action}" modelAttribute="homepage" enctype="multipart/form-data">
            <form:hidden path="id" value="${homepage.id}"/>

            <div class="form-group">
                <label for="video">Video</label>
                <form:input class="form-control" path="video" placeholder="Enter youtube video's id here..." />
            </div>

            <div class="form-group row">
                <form:hidden path="bannerId.id" value="${homepage.bannerId.id}"/>
                
                <c:forEach items="${homepage.bannerId.imagesCollection}" var="image" varStatus="status">
                    <div class="col-2">
                        <label for="bannerId.imagesCollection[${status.index}].file">Image ${status.index + 1}</label>
                        <img src="${image.url}" width="120"/>
                        
                        <form:input type="file" path="bannerId.imagesCollection[${status.index}].file" />
                        <form:hidden path="bannerId.imagesCollection[${status.index}].id" value="${image.id}"/>
                        <form:hidden path="bannerId.imagesCollection[${status.index}].url" value="${image.url}"/>
                    </div>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="content">Content</label>
                <form:textarea path="content" class="form-control" rows="3" id="content"></form:textarea>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>

        </form:form>

    </div>
</main>


<script src="https://cdn.tiny.cloud/1/hkiir3w66qsfdv856ttemmqztxxfkcpgkr1ebc69har0t88n/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>

<script>
    tinymce.init({
        selector: 'textarea#content',
        plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tableofcontents footnotes mergetags autocorrect typography inlinecss',
        toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | emoticons charmap | removeformat'
    });

</script>
