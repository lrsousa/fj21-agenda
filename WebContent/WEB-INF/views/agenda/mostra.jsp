<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link type="text/css" href="resources/css/jquery.css" rel="stylesheet">
		<script type="text/javascript" src="resources/js/jquery.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Altera Contato</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		Formulário para alteração de contatos:<br />
		<form action="alteraContato" method="post">
			ID:<input value="${contato.id}" name="id" readonly="readonly"><br />
			Nome:<input value="${contato.nome}" name="nome"><br />
			E-mail:<input value="${contato.email}" name="email"><br />
			Endereço:<input value="${contato.endereco}" name="endereco"><br />
			Data de Nascimento: <caelum:campoDataAtualizar id="dataNascimento"/><br />
			<input type="submit" value="Enviar">
		</form>
		<c:import url="rodape.jsp" />		
	</body>
</html>