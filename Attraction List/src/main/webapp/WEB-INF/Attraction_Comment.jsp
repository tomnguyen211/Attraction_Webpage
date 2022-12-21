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
<h1> <a href="Attraction_Homepage"> Attraction </a> - ${ name } </h1>

<table class="table table-bordered">
	<thead>
	    <tr>
	      <th scope="col">Review Name</th>
	      <th scope="col">Review</th>
	      <th></th>
	    </tr>
 	</thead>
 	<tbody>
 		<c:forEach items="${entries_comment}" var="entry" varStatus="loop">
 			<tr>
 				<td>${ entry.name }</td>
	 			<td>${ entry.comment }</td>
	 			<td></td>
 			</tr>			
 		</c:forEach>
 		<form method='post'>
 			<tr>
 				<td><input type="text" class="form-control" name="a"></td>
 				<td><input type="text" class="form-control" name="b"></td>
 				<td><input class="btn btn-primary" type="submit" value="Submit"></td>
 			</tr>
 		</form>
 	</tbody>
</table>

</body>
</html>