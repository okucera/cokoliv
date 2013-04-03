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
			if(document.insertGuestbookItemForm.pokus.value=="rihanna"){
				alert("Je to tam");
				document.insertGuestbookItemForm.submit();
			} else {
				alert("Neni to tam");
			}
		} 
	</script>
	<img src="GetImageServlet?image=null"/>
	<form name="uploadForm" action="FileUploadServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="newsImageFile" size=50 onChange="servlet: fileChangedHandler()"/>
	</form>
	
	
		<script>
		function fileChangedHandler() {
			if(document.insertGuestbookItemForm.pokus.value=="rihanna"){
				alert("Je to tam");
				document.insertGuestbookItemForm.submit();
			} else {
				alert("Neni to tam");
			}
		} 
	</script>
	<form name="insertGuestbookItemForm" action="ServletJakHovado" method="post">
		<input type=text name="pokus">
		<input type=button value="posli to tam"  onclick="fileChangedHandler() ">
	</form>
</body>
</html>