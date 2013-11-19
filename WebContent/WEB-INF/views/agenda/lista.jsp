<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="resources/js/jquery.js"></script>
		<title>Lista Contatos</title>
	</head>
	<body>
		<script type="text/javascript">
			function excluirContato(id) {
				$.post("removeContato", {'id' : id}, function() {
					$("#contato_" + id).closest("tr").hide();
				});
			}
		</script>
		
		<c:import url="cabecalho.jsp" />
		<a href="novoContato">Novo Contato</a>
		<br /><br />
		<table>
			<tr bgcolor="#aaee88">
				<th>ID</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Endereço</th>
				<th>Data Nascimento</th>
				<th>Opção</th>
			</tr>
			
			<c:forEach items="${contatos}" var="contato" varStatus="contador">
				<tr id="contato_${contato.id}" bgcolor="#${contador.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
					<td>${contato.id}</td>
					<td>${contato.nome}</td>
					<td>
						<c:choose>
							<c:when test="${not empty contato.email}">
								<a href="mailto:${contato.email}">${contato.email}</a>
							</c:when>
							<c:otherwise>
								E-mail não informado
							</c:otherwise>
						</c:choose>
					</td>
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
					<td>
						<a href="mostraContato?id=${contato.id}">Editar</a>
						<a href="#" onclick="if(confirm('Confirma exclusão?')) excluirContato(${contato.id})">Remover</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<a href="logout">Sair</a>
		<c:import url="rodape.jsp" />
	</body>
</html>