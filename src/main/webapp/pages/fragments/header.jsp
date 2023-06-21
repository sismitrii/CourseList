<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Boolean error = false; %>
<html>
	<head>
	<!-- META -->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <!-- INTERNAL RESSOURCES -->
	<link rel="icon" type="image/x-icon" href="/ShoppingList/images/favicon.ico">
	<link rel="stylesheet" href="/ShoppingList/css/style.css">
	<script charset="UTF-8" type="text/javascript" src="/ShoppingList/js/script.js"></script>
	<!-- EXTERNAL RESSOURCES -->
	<!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- Bootstrap core JavaScript -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
   
	
	<title>ShoppingList - ${param.mainTitle}</title>
	</head>
<body class="container">

	<header class="py-3 bg-dark header-demodule fixed-top">
	 <div class="container text-center text-white">
	 	<h1>${param.mainTitle}</h1>
	 </div>
	</header>
	<div class="headerSpacer"></div> 