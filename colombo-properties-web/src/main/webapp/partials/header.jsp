<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<header role="banner">
	<div class="container-fluid bg-white">
		<img src="../img/Screenshot (297).png" width="700">
	</div>


	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-warning "
		style="min-height: 75px;">


		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto" style="margin-left: 100px;">

				<li class="nav-item active" style="padding-right: 15px;"><a
					class="nav-link" href="/"><strong>Home</strong> <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item active" style="padding-right: 15px;"><a
					class="nav-link" href="#"><strong>About Us</strong> <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item active" style="padding-right: 15px;"><a
					class="nav-link" href="/contact"><strong>Contact</strong> <span
						class="sr-only">(current)</span></a></li>

				<c:choose>
					<c:when test="${role == 'admin'}">
						<li class="nav-item active" style="padding-right: 15px;"><a
							class="nav-link" href="/contact-record"><strong>Contact
									Requests</strong> <span class="sr-only">(current)</span></a></li>
					</c:when>
					<c:otherwise>
						<a></a>

					</c:otherwise>
				</c:choose>

			</ul>
			<!-- 		<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2 " style="width: 250px;"
					type="search" placeholder="What are you looking for ?"
					aria-label="Search">
				<button class="btn btn-light" type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form> -->

			<ul class="navbar-nav col-auto">
				<li class="nav-item" style="padding-right: 60px;"><a
					type="button" class="btn btn-outline-dark" href="/property/create">POST
						YOUR AD</a></li>
			</ul>

			<c:choose>
				<c:when test="${not empty role}">
					<ul class="navbar-nav" style="padding: 0px;">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <img src="../img/avatar-5.jpg"
								class="rounded-circle z-depth-0" alt="avatar image" height="50">
						</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="#">${role}</a> <a
									class="dropdown-item" href="/logout">Sign out</a>

							</div></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav col-auto">
						<li class="nav-item" style="padding-right: 60px;"><a
							type="button" class="btn btn-outline-dark" href="/login">
								login</a></li>
					</ul>
				</c:otherwise>
			</c:choose>

		</div>
	</nav>
</header>