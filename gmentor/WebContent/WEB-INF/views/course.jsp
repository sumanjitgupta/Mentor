<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Enter Course Details</h1>
 <form action = "<%= request.getContextPath() %>/addcourse" method="post">
   <table>
	<tr>
	<td>Course-Name</td>
	<td><input type="text" name="coursename" /> </td>
	</tr>
	
	<tr>
	<td>Time line</td>
	<td><input type="text" name="timeline" /> </td>
	</tr>
	
	<tr>
	<td>Link</td>
	<td><input type="text" name="link" /> </td>
	</tr>
	
	<tr>
	<td> Details</td>
	<td><input type="text" name="details" /> </td>
	</tr>
	
	<tr>
	<td> Summary</td>
	<td><input type="text" name="summary" /> </td>
	</tr>
   </table>
   <input type="submit" value="submit" />
 </form>
</div>
</body>
</html>