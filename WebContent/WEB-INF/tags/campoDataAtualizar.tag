<%@ attribute name="id" required="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<input value="<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />" id="${id}" name="${id}"/>
<script>
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>