<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/cokoliv_lib.tld" prefix="CokolivTags"%>
<%@page import="cokoliv.enumerate.Forms"%>
<%@page import="cokoliv.flowdata.*" %>
<%@page import="cokoliv.databobjects.*" %>
<%@page import="cokoliv.support.*" %>
<%
	Forms formId = Forms.FRM002;
	LoggedUser user = CokolivContext.getContext().getLoggedUser();	
	String msgCode = request.getParameter("msg");
%>
<html>
	<head>
		<link rel="stylesheet" href="styles/night.css" type="text/css">
		<title>index</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<table class="screen">
			<tr>
				<td class="logo">
	  				<CokolivTags:Logo nextFormId="<%=formId %>" loggedUser="<%= user %>"/>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td class="main">
	  				<CokolivTags:HorizontalMenu activeFormId="<%= formId %>"/>					
					<CokolivTags:BasicPanel title="Změna informací o uživateli" activeFormId="<%= formId %>">
						<CokolivTags:ChangeUserDetailPanel user="<%= user %>" msgCode="<%=msgCode %>"/>
					</CokolivTags:BasicPanel>				
	  			</td>
	  		</tr>
		</table>
	</body>
</html>