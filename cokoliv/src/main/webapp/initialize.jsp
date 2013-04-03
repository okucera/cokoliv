<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/cokoliv_lib.tld" prefix="CokolivTags"%>
<%@page import="cokoliv.enumerate.Forms"%>
<%@page import="cokoliv.flowdata.*" %>
<%@page import="cokoliv.support.Constants" %>
<%@page import="cokoliv.enumerate.UploadRepositories" %>
<%
	Forms formId = Forms.FRM001;	
	Object objData = request.getAttribute(Constants.FLOW_DATA);
	IFlowData data = objData == null ? null : (IFlowData) objData;
%>
<html>
	<head>
		<link rel="stylesheet" href="styles/night.css" type="text/css">
		<title>index</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<form action="InitializeServlet" method="post">
			<table border="0" align="center">
				<input type=password name="init_start_db">
				<input type=submit value="Připravit databázi"/>
			</table>
		</form>
	</body>
</html>