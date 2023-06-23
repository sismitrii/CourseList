<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Condition</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ServletNewCondition" method="POST">
	<label for="inputCondition">Accepter des conditions que je ne connais pas</label>
	<input type="checkbox" name="inputCondition"/>
	<button type="submit">Valider mon choix</button>
</form>
</body>
</html>