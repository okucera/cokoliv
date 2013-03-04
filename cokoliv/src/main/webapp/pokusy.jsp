<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script>
		function fileChangedHandler() {
			alert('necuum');
			document.uploadForm.submit();
		} 
	</script>
	<img src="UploadImageServlet?image=null"/>
	<form name="uploadForm" action="FileUploadServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="newsImageFile" size=50 onChange="servlet: fileChangedHandler()"/>
	</form>
</body>
</html>