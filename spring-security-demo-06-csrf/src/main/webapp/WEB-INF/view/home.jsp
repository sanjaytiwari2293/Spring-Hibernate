<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<title>Welcome to Home Page</title>
	</head>
	
	<body>
		<h2>Hello! - Yoohoo!! - Hola!</h2>
		<hr>
		<p>
			Welcome to the Home Page!!
		</p>
		
		<!-- logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			
			<input type="submit" value="Logout">
			
		</form:form>
	
	</body>

</html>