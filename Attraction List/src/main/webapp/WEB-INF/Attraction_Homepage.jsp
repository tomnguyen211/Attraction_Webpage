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

<h1> Attractions </h1>

<a href="Attraction_Add" role="button">Add An Attraction</a>

<table class="table table-bordered">
	<thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Phone</th>
	    </tr>
 	</thead>
 	<tbody>
 		<c:forEach items="${entries_attraction}" var="entry" varStatus="loop">
 			<tr>	
 				<td><a href="Attraction_Comment?id=${entry.id}">${ entry.name }</a></td>	
 			<td>${ entry.phone }</td>	
 			</tr> 					
 		</c:forEach>
 	</tbody>

</table>

</body>
</html>