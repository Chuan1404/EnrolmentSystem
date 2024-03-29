<%-- 
    Document   : login
    Created on : Mar 21, 2023, 2:06:26 PM
    Author     : AnChuPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<main id="loginpage">
    <section class="vh-100" style="background-color: #9A616D;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-xl-10">
                    <div class="card" style="border-radius: 1rem;">
                        <div class="row g-0">
                            <div class="col-md-6 col-lg-5 d-none d-md-block">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
                                     alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                            </div>
                            <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                <div class="card-body p-4 p-lg-5 text-black">

                                    <c:url var="action" value="/auth/login"/> 
                                    <form:form method="post" action="${action}" modelAttribute="user">
                                        <div class="d-flex align-items-center mb-3 pb-1">
                                            <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                            <span class="h1 fw-bold mb-0">Logo</span>
                                        </div>

                                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your account</h5>

                                        <div class="form-outline mb-4">
                                            <form:input path="username" id="form2Example17" class="form-control form-control-lg" />
                                            <label class="form-label" for="form2Example17">User name</label>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <form:input type="password" path="password" id="form2Example27" class="form-control form-control-lg" />
                                            <label class="form-label" for="form2Example27">Password</label>
                                        </div>
                                        <div class="pt-1 mb-4">
                                            <button type="submit" class="btn btn-dark btn-lg btn-block" type="button">Login</button>
                                        </div>

                                    </form:form>

                                    <div class="row">
                                        <div class="pt-1 mb-4 col-md-6 col-12 text-center">
                                            <a id="facebook-btn" class="btn btn-primary" style="background: #3b5998;" href="<c:url value="/oauth2/authorization/facebook" />" role="button"
                                               ><i class="fab fa-facebook-f"></i
                                                ></a>
                                        </div>
                                        <div class="pt-1 mb-4 col-md-6 col-12 text-center">
                                            <a id="google-btn" class="btn btn-primary" style="background: #dd4b39;" href="<c:url value="/oauth2/authorization/google" />" role="button"
                                               ><i class="fab fa-google"></i
                                                ></a>
                                        </div>
                                    </div>


                                            <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account? <a href="<c:url value="/auth/register" />"
                                                                                                              style="color: #393f81;">Register here</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</main>
<style>
    #facebook-btn::before {
        /*display: none;*/
        background: #20428b;
    }
</style>