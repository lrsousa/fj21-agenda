<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link type="text/css" href="resources/css/jquery.css" rel="stylesheet">
		<script type="text/javascript" src="resources/js/jquery.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Adiciona Contato</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		Formulário para adição de contatos:<br />
		<form:errors path="contato.nome" />
		<form action="adicionaContato" method="post">
			Nome: <input type="text" name="nome" /><br />
			E-mail: <input type="text" name="email" /><br />
			Endereço: <input type="text" name="endereco" /><br />
			Data Nascimento: <caelum:campoData id="dataNascimento" /><br />
			<input type="submit" value="Gravar"/>
		</form>
		<br />
		<a href="listaContatos">Lista</a>
		<c:import url="rodape.jsp" />
	</body>
</html>