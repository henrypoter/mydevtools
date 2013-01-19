<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="UTF-8"/>
<meta name="robots" content="all"/>
<meta name="rating" content="general"/>
<meta name="title" content="Free Online JSON Formatter - javaer.net"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9"/>
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/prettify.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/freeformatter.css"/>

<title>${pageTitle}</title>
</head>
<body onload="prettyPrint();">
<div class="topbar">
	<div class="topbar-inner">
		<div class="container-fluid">
			<a class="brand" href="index.html">javer.net</a>
			<ul class="nav">
				<li><a href="index.html">Home</a></li>
				<li><a href="index.html"><strong>HTTPS</strong></a></li>
				<li><a href="mailto:henrypoter@126.com">Contact</a></li>
			</ul>
			<div class="social" style="float:right;">
				<div class="fb-like" data-href="#" data-send="false" data-layout="button_count" data-width="50" data-show-faces="true" data-font="arial"></div>
				<!-- Place this tag where you want the +1 button to render -->
				<div style="float: left; padding: 8px 5px 5px;">
					<g:plusone></g:plusone>
				</div>
			</div>
		</div>
	</div>
</div><!--end topbar-->
<div class="container-fluid">