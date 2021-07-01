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
		<H2>Books Categories</H2>
	<?php
	  require_once 'api/category.php';
		
		
		  // header('Content-Type: application/json');
		 
 		echo '<table class="table table-bordered ">
 		<thead class = "thead-dark"
 		<tr>
 			<th scope="col">Category_id</th>
 			<th scope="col">Category_name</th>
 		</tr>';
 		foreach ($decoded as $key => $value) {
 			
 				echo '<tr>
 				 	<td>'.$value->categoryId.'</td>
 				 	<td>'.$value->categoryName.'</td>

 				</tr>';
 	
 		}

 		echo '</table>';
	?>
   </div>

</body>
</html>