<?php
  // session_start();
  // include_once 'api/category_api.php';

  // // set session variables
  // $_SESSION["category_id"] = $_POST['category_id'];
  // $_SESSION['category_name'] = $_POST('category_name');
  session_start();
  $_SESSION[ 'id'] = 342;
  if(!isset($_SESSION[ "login"])){
  	echo "please login first";
  }
  $user = $_SESSION["login"];
  $name = $_SESSION["name"] ?? 'maina';

 session_destroy()
 ?>