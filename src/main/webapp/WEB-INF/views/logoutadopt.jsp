<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>PETS H</title>
<%@ include file="/WEB-INF/views/include.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath }/asset/css/bootstrap.min.css" rel="stylesheet"type="text/css" />
<link href="${pageContext.request.contextPath }/asset/css/icons.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/asset/css/app.min.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<header id="topnav">
		<div class="navbar-custom">
			<div class="container-fluid">
				<div align="center">
					
						<h1>PETS H</h1>
					
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="topbar-menu">
			<div class="container-fluid">
				<div id="navigation" >
					<!-- Navigation Menu-->
					<ul class="navigation-menu">
						<li class="has-submenu"><a href="/petsh/home">HOME</a></li>
						<li class="has-submenu"><a href="/petsh/adopt">ADOPT</a></li>
						<li class="has-submenu"><a href="/petsh/forum">FORUM</a></li>
						<li class="has-submenu"><a href="#">ACCOUNT</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="/petsh/signin">SIGN IN</a></li>
										<li><a href="/petsh/signup">SIGN UP</a></li>
									</ul>
								</li>
							</ul>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</header>


	<div class="wrapper">
		<div class="container-fluid">

			<!-- start page title -->
			<div class="row">
				<div class="col-12">
					<div class="page-title-box">
						<div class="page-title-right">
							<ol class="breadcrumb m-0">
								<li class="breadcrumb-item"><a href="/petsh/home">HOME
										></a></li>
								<li class="breadcrumb-item active"><a href="/petsh/adopt">ADOPT
										</a></li>
							</ol>
						</div>
						<h4 class="page-title">PETS</h4>
					</div>
				</div>
			</div>
			
			<div class="row">
                    <div class="col-12" >
                        <div class="card-box">
                            <div class="row">
                               
                                <div class="col-lg-8">
                                    <form class="form-inline" action="/petsh/adopt/searchbycolor" method="post">
                                        <div class="form-group" >
                                            <label for="inputPassword2" class="sr-only">Search</label>
                                            <input type="search" class="form-control" name="color" placeholder="Color">
                                        	<button class="btn btn-primary waves-effect waves-light" type="submit">Search</button>
                                        </div>
                                        
                                    </form>
                                </div>
                               
                            </div> <!-- end row -->
                        </div> <!-- end card-box -->
                    </div><!-- end col-->
                </div>

			<div class="row">

				<c:forEach items="${uiModel.petList}" var="singlePet">
					<div class="col-lg-6 col-xl-3">
						<!-- Simple card -->
						<div class="card">
							<img class="card-img-top img-fluid"
								src="${singlePet.petURL}" alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title" align="center"><c:out value="${singlePet.petName}" /></h5>
								<p align="center"><c:out value="${singlePet.petColor}" /></p>
								<p align="center"><a href="/petsh/adopt/view/${singlePet.petId}"  class="btn btn-primary waves-effect waves-light">More</a></p>
								
							</div>
						</div>

					</div>
				</c:forEach>
			</div>
			
			
		</div>
	</div>
	<footer class="footer">
		<div class="container-fluid"></div>
	</footer>


	<script src="${pageContext.request.contextPath }/asset/js/vendor.min.js"></script>
	<script src="${pageContext.request.contextPath }/asset/js/app.min.js"></script>

</body>
</html>

 