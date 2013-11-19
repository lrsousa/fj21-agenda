<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	<body>
		<c:import url="agenda/cabecalho.jsp" />
		<h2>Login</h2>
		<form action="efetuaLogin" method="post">
			Login: <input type="text" name="login" /><br />
			Senha: <input type="password" name ="senha" /><br />
			<input type="submit" value="Entrar" />
		</form>
		<c:import url="agenda/rodape.jsp" />
	</body>
</html>