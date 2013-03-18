<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page import="cokoliv.model.NewsModel"%>
<%@page
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/cokoliv_lib.tld" prefix="CokolivTags"%>
<%@page import="cokoliv.enumerate.Forms"%>
<%@page import="cokoliv.flowdata.*" %>
<%@page import="cokoliv.support.Constants" %>
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
		<table class="screen">
			<tr>
				<td class="logo">
	  				<CokolivTags:Logo nextFormId="<%=formId %>"/>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td class="main">
	  				<CokolivTags:HorizontalMenu activeFormId="<%= formId %>"/>					
					<CokolivTags:BasicPanel title="Nov!nky" activeFormId="<%= formId %>">
						<CokolivTags:WizzardComponent activeFormId="<%= formId %>">
							<CokolivTags:ImageWizzardItem flowData="<%= data %>"/>
							<CokolivTags:NewsTextWizzardItem flowData="<%= data %>"/>
						</CokolivTags:WizzardComponent>
						<CokolivTags:News/>
					</CokolivTags:BasicPanel>				
	  			</td>
	  		</tr>
		</table>
	</body>
</html>