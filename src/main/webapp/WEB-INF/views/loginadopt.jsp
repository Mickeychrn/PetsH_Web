<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>PETS H</title>
<%@ include file="/WEB-INF/views/include.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="${pageContext.request.contextPath }/asset/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/asset/css/icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/asset/css/app.min.css"
	rel="stylesheet" type="text/css" />


<link
	href="${pageContext.request.contextPath }/asset/libs/custombox/custombox.min.css"
	rel="stylesheet">
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
				<div id="navigation">
					<!-- Navigation Menu-->
					<ul class="navigation-menu">
						<li class="has-submenu"><a
							href="/petsh/home/${profileMap.user.userId}">HOME</a></li>
						<li class="has-submenu"><a
							href="/petsh/adopt/${profileMap.user.userId}">ADOPT</a></li>
						<li class="has-submenu"><a
							href="/petsh/forum/${profileMap.user.userId}">FORUM</a></li>
						<li class="has-submenu"><a
							href="/petsh/profile/${profileMap.user.userId}">PROFILE</a></li>


						<c:set var="authority" value="${profileMap.user.authority}" />
						<c:if test="${authority == 0}">
							<li class="has-submenu"><a href="/petsh/admin/user">ADMIN</a></li>

						</c:if>
						<li class="has-submenu"><a href="/petsh/home">LOG OUT</a></li>
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
								<li class="breadcrumb-item"><a
									href="/petsh/home/${profileMap.user.userId}">HOME ></a></li>
								<li class="breadcrumb-item active">ADOPT</li>
							</ol>
						</div>
						<h4 class="page-title">PETS</h4>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<div class="card-box">
						<div class="row">
							<div class="col-lg-8">
								<form class="form-inline" action="/petsh/adopt/${profileMap.user.userId}/searchbycolor" method="post">
									<div class="form-group">
										<label for="inputPassword2" class="sr-only">Search</label> <input
											type="search" class="form-control" name="color"
											placeholder="Color">
										<button class="btn btn-primary waves-effect waves-light"
											type="submit">Search</button>
									</div>

								</form>



							</div>
							<div class="col-lg-2"></div>
							<div class="col-lg-2">
								<a href="#custom-modal"
									class="btn btn-info waves-effect waves-light"
									data-animation="fadein" data-plugin="custommodal"
									data-overlayColor="#38414a"> Add New</a>
							</div>



						</div>
						<!-- end row -->
					</div>
					<!-- end card-box -->
				</div>
				<!-- end col-->
			</div>

			<div class="row">

				<c:forEach items="${profileMap.pets}" var="singlePet">
					<div class="col-lg-6 col-xl-3">
						<!-- Simple card -->
						<div class="card">
							<img class="card-img-top img-fluid" src="${singlePet.petURL}"
								alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title" align="center">
									<c:out value="${singlePet.petName}" />
								</h5>
								<p align="center">
									<c:out value="${singlePet.petColor}" />
								</p>
								<p align="center">
									<a
										href="/petsh/adopt/${profileMap.user.userId}/view/${singlePet.petId}"
										class="btn btn-primary waves-effect waves-light">More</a>
								</p>

							</div>
						</div>

					</div>
				</c:forEach>
			</div>


		</div>

		<!-- Modal -->
		<div id="custom-modal" class="modal-demo">
			<button type="button" class="close"
				onclick="Custombox.modal.close();">
				<span>&times;</span><span class="sr-only">Close</span>
			</button>
			<h4 class="custom-modal-title">Add Pets</h4>
			<div class="custom-modal-text text-left">

				<div class="form-group">
					<label>Pet Name</label> <input name="petName" class="form-control"
						required="required">
				</div>
				<div class="form-group">
					<label>Pet Color</label> <input name="petColor"
						class="form-control" required="required">
				</div>
				<div class="form-group">
					<label>Pet Category</label> <input name="petCategory"
						class="form-control" required="required">
				</div>
				<div class="form-group">
					<label>Pet Gender</label> <input name="petGender"
						class="form-control" required="required">
				</div>
				<div class="form-group">
					<label>Pet Description</label>
					<textarea name="petDescription" class="form-control"
						required="required"></textarea>
				</div>
				<div class="form-group">
					<label>Choose a file</label> <input type="file" id="imgurl"
						accept="image/png,image/gif,image/jpeg" /> <br> <br>
				</div>
				<input type="button" value="POST" class="btn btn-primary"
					required="required" /> <br>

			</div>
		</div>
	</div>
	<footer class="footer">
		<div class="container-fluid"></div>
	</footer>



	<script
		src="${pageContext.request.contextPath }/asset/libs/custombox/custombox.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/asset/js/vendor.min.js"></script>
	<script src="${pageContext.request.contextPath }/asset/js/app.min.js"></script>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script>
		var petName;
		var petColor;
		var petGender;
		var petCategory;
		var petDescription;

		$('input[name="petName"]').on('change', function() {
			petName = $('input[name="petName"]').val();
		});

		$('input[name="petColor"]').on('change', function() {
			petColor = $('input[name="petColor"]').val();
		});

		$('input[name="petCategory"]').on('change', function() {
			petCategory = $('input[name="petCategory"]').val();
		});

		$('input[name="petGender"]').on('change', function() {
			petGender = $('input[name="petGender"]').val();
		});

		$('textarea[name="petDescription"]').on('change', function() {
			petDescription = $('textarea[name="petDescription"]').val();
		});

		var result;
		$('input[type=file]').on('change', function() {
			var reader = new FileReader();
			reader.onload = function(e) {
				result = reader.result;
			}
			reader.readAsDataURL(this.files[0])
		});
		$('input[type=button]').click(function() {
			var data = "content=" + petName;

			$.ajax({
				type : "post",
				url : "1/addpet",
				data : {
					content : result,
					petName : petName,
					petColor : petColor,
					petGender : petGender,
					petCategory : petCategory,
					petDescription : petDescription
				},
				success : function(msg) {
					window.location.href = '';
					alert("You have added a pet");
				},
				error : function(msg) {
					alert("Please input all the parameter");
				}

			});
		});
	</script>
</body>
</html>

