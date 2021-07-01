<!DOCTYPE html>
<html>
<head>
	<title>Admin</title>
	<!-- bootstrap offline css -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<!-- responsive meta tag -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
	<!-- nav -->
	<ul class="nav nav-tabs form-text ">
		<li class="nav-item">
			<a class="nav-link active" data-toogle="tab" href="index.php">Home</a></li>
		<!-- </li>
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="admin.php">Admin</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#"> Book Category</a>
				<a class="dropdown-item" href="#"> Book Name</a>
				
			</div>
		</li> -->
		<ul class="nav nav-tabs form-text ">
		<li class="nav-item">
			<a class="nav-link active" data-toogle="tab" href="admin.php">Admin</a>
		</li>
	</ul>
</ul>

	<div class="container pt-4" style="margin-top: 5%">
		<div class="input-group rounded">
			<input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" name="">
			<button type="button" class="btn btn-outline-primary" style="margin-left: 2%">search</button>
		</div>
		
		<H2>What you can do</H2>
 	<button type="button" class="btn btn-dark" onclick="document.location='AllBooks.php'">List of books</button>
 	<br></br>
 <button type="button" class="btn btn-dark" onclick="document.location='categories.php'">List of Book Categories</button>

	</div>

 <script src="css/bootstrap.min.js">
</script>
</body>
</html>