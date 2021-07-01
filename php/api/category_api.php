
<?php

  $url = 'http://localhost:8080/Book/addCategory';
  $processed = FALSE;
  $error = '';
  $data = [
       "category_id"=> "c20",
       "category_name"=> "animation",
  ];


    $curl = curl_init($url);
          curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
          curl_setopt($curl, CURLOPT_CUSTOMREQUEST, "POST");
          curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($data));
          curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
          curl_setopt($curl, CURLOPT_HTTPHEADER, array(
              'Content-Type: application/json',
              'Content-Length: ' . strlen(json_encode($data)),
          ));

$response = curl_exec($curl);
$decoded = json_decode($response);
curl_close($curl);
// echo $response;



if($decoded->{'status'} == 0){
	$processed = TRUE;

}
else{
	$error = $decoded->{'status'};
  $err = $decoded->{'description'};
}

if (!$processed && $error != ''){
  echo $error;
  echo $err;
}

?>
