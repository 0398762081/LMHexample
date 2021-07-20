<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<%@ page import="vn.molu.util.SecurityUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="#page-top"><img src="<c:url value='/template/web2/assets/img/team/navbar-logo.svg'/>" alt="..." /></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                <li class="nav-item"><a class="nav-link" href="#services">Services</a></li>
                <li class="nav-item"><a class="nav-link" href="#portfolio">Portfolio</a></li>
                <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
                <li class="nav-item"><a class="nav-link" href="#team">Team</a></li>
                <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">All Products</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                        <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
<%--                        <c:forEach items="listcategory" var="item">--%>
<%--                            <li><a class="dropdown-item" href="#!">${item.name}</a></li>--%>
<%--                        </c:forEach>--%>
                    </ul>
                </li>

                <security:authorize access="isAnonymous()">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/dang-nhap.html'/>">Đăng nhập</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Đăng ký</a>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="#">Wellcome <%=SecurityUtils.getPrincipal().getFullName()%></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/thoat.html'/>">Thoát</a>
                </li>
                </security:authorize>
            </ul>

            <form class="d-flex">
                <button class="btn btn-outline-dark mystyle" type="submit">
                    <i class="bi-cart-fill me-1"></i>
                    Cart
                    <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                </button>
            </form>


        </div>
    </div>
</nav>
</html>

