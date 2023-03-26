<%-- 
    Document   : article
    Created on : Mar 26, 2023, 12:43:47 PM
    Author     : jackc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>ARTICLE TEST</h1>
<c:url value="/admin/article" var="action"/>
<form:form action="${action}" method="post" modelAttribute="article">
    <form:textarea path="content"></form:textarea> <!--the form:textarea phai khong co value o trong  -->
    <form:button type="submit" value="GUI"/>
</form:form>
    
    <!-- import thu vien -->
<script src="https://cdn.tiny.cloud/1/hkiir3w66qsfdv856ttemmqztxxfkcpgkr1ebc69har0t88n/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>

<script>
    tinymce.init({
      selector: 'textarea#content', // chon textarea de sua
       plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tableofcontents footnotes mergetags autocorrect typography inlinecss',
      toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | emoticons charmap | removeformat'
     
      
    });
    
   
  </script>
    
    

