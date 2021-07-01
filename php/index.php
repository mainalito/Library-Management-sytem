<!DOCTYPE html>
<html lang="en">
<head>
	<title>Books Inventory</title>
	<!-- bootstrap offline css -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<!-- responsive meta tag -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<body>

<!-- /* Code to generate a CSRF token and store the same */ -->
<!-- ... -->
<?php
 session_start();
 function generate_token() {
 // Check if a token is present for the current session
 if(!isset($_SESSION["csrf_token"])) {
 // No token present, generate a new one
 $token = random_bytes(64);
 $_SESSION["csrf_token"] = $token;
 } else {
 // Reuse the token
 $token = $_SESSION["csrf_token"];
 }
 return $token;
 }
?>
	<!-- nav -->
	<ul class="nav nav-tabs form-text ">
		<li class="nav-item">
			<a class="nav-link active" data-toogle="tab" href="index.php">Home</a>
		</li>
		<!-- <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Admin</a>
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
	<div class="container pt-4" style="margin-top: 5%">
	  <div class="jumbotron jumbotron text-center">
	<h1>ADMIN SECTION</h1>
</div>
	<h2>Add book categories</h2>

 <form method="POST">
 	<div class="form-group">
 		<label for="category_id">Category Id</label>
 		<input type="category_id" class="form-control input" id="category_id" aria-describedby="categoryId" placeholder="enter category_id" required="true" class="form-control input-lg" name="category_id">
 		<small id="categoryId" class="form-text text-muted">Please fill correctly</small>
 	</div>
 	<div class="form-group">
 		<label for="category_name">Category name</label>
 		<input type="category_name" class="form-control" id="category_name" aria-describedby="categoryName" placeholder="enter category_name" required="true" name="category_name">
 		<small id="categoryName" class="form-text text-muted">Please fill correctly</small>
 	</div>
 	<input type="hidden" name="csrf_token" value="<?php echo generate_token();?>">
 	<button type="submit" class="btn btn-primary">Submit</button>
 	<!-- <div>
 		<p>
 			<?php echo $_POST['category_name'];?>
 		</p>
 	</div> -->
 	
 </form>
 <div class="row" style="margin-top: 30px">
 	<div class="col-sm-4">
 		<h3>About</h3>
 		<p>Lorem ipsum</p>
 	</div>
 		<div class="col-sm-4">
 		<h3>Contact</h3>
 		<i class="bi bi-telephone"></i>
 		<p>Lorem ipsum</p>
 	</div>
 		<div class="col-sm-4">
 		<h3>founded</h3>
 		<p>Lorem ipsum</p>
 	</div>
 </div>
 </div>
 
  <script src="css/bootstrap.min.js">
</script>

</body>

</html>