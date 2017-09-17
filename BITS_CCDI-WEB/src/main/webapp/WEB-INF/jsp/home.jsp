<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="ex" uri="/WEB-INF/envtaglib.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TEST CCDI</title>
</head>
<body>
<ex:env message="envkey"/>

	<form action="getData" method="post">
		<input type="text" name="data" value="test" alt="Enter data">
		<input type="submit">
	</form>

<form action="getEnv" method="post">
		<input type="text" name="data" value="test" alt="Enter data">
		<input type="submit">
	</form>

</body>
</html>