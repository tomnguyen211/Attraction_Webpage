<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>
<h1> <a  href="Attraction_Homepage"> Attraction </a> - Add An Attraction </h1>
<table class="table table-bordered">
	<form method='post'>
		<tr>
			<td><label class="form-label">Attraction Name</label></td>
			<td><input type="text" class="form-control" name="c"></td>
		</tr>
		<tr>
			<td><label class="form-label">Phone Number</label></td>
			<td><input type="text" class="form-control" name="d"></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" type="submit" value="Submit"></td>	
		</tr>
	</form>
</table>
</body>
</html>