<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery.js"></script>
<script src="Components/Advice.js"></script>

<head>
<meta charset="ISO-8859-1">
<title>Advising Group Details</title>
</head>
<body>

     <div class="container">
<div class="row">
<div class="col-8">

<h1 class="m-3">Advising Group Details</h1>
<form id="formStudent">

<br>

<div class="row">
<div class="col-12" id="coladviser">
</div>

</div>

</div>

          <!-- NAME -->
          
<div class="input-group input-group-sm mb-3">
<div class="input-group-prepend">
<span class="input-group-text" id="lblName">Adviser Name: </span>
</div>
<input type="text" id="txtName" name="txtName">
</div>

          <!-- RESEARCH GROUP ID -->>
          
 <div class="input-group input-group-sm mb-3">
<div class="input-group-prepend">
<span class="input-group-text" id="lblRGId">Research Group Id: </span>
</div>
<input type="text" id="txtId" name="txtId">
</div>

         <!-- RESEARCH TYPE -->
          
<div class="input-group input-group-sm mb-3">
<div class="input-group-prepend">
<span class="input-group-text" id="lblRtype">Research Type: </span>
</div>
<input type="text" id="txtType" name="txtType">
</div>

         <!-- Advising TYPE -->
          
<div class="input-group input-group-sm mb-3">
<div class="input-group-prepend">
<span class="input-group-text" id="lblAdvisingType">Advising Type: </span>
</div>
<input type="text" id="txtAdType" name="txtAdType">
</div>

         <!-- ADVISER CURRENT LEVEL -->
          
<div class="input-group input-group-sm mb-3">
<div class="input-group-prepend">
<span class="input-group-text" id="lblAdCuLvl">Adviser Current Level: </span>
</div>
<select id="ddlLevel" name="ddlLevel">
<option value="0">--Select level--</option>
<option value="1">Level 1</option>
<option value="2">Level 2</option>
<option value="3">Level 3</option>

</select>
</div>


     <div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<input type="button" id="btnSave" value="Save" class="btn btn-primary">

</form>
</div>
</div>
<br>

<div class="row">
<div class="col-12" id="colAdviser">

</div>
</div>
</div>


</body>
</html>