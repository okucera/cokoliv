<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/cokoliv_lib.tld" prefix="CokolivTags"%>
<%@page import="cokoliv.enumerate.Forms"%>
<%@page import="cokoliv.flowdata.*" %>
<%@page import="cokoliv.support.Constants" %>
<%@page import="cokoliv.enumerate.UploadRepositories" %>
<%@page import="cokoliv.flowdata.manager.FlowDataManager"%>
<%
	Forms formId = Forms.FRM006;	
	String dataKey = request.getParameter(Constants.FLOW_DATA_KEY);	
	IFlowData data = (dataKey == null || dataKey.equals("")) ? null : FlowDataManager.getInstance().getFlowDataByKey(dataKey);
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
					<CokolivTags:BasicPanel title="Vzkazy" activeFormId="<%= formId %>">
						<CokolivTags:Guestbook flowData="<%= data %>"/>
					</CokolivTags:BasicPanel>				
	  			</td>
	  		</tr>
		</table>
	</body>
</html>