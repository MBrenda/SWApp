<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<h1>Direccion</h1>

	<sf:form action="${pageContext.request.contextPath}/direccion/save" method="post" commandName="direccion">
		<table>	
			<tr>
				<td>Calle</td>
				<td> <sf:input path="calle" type="text"/> </td> 
			</tr>
			<tr>
				<td>Codigo Postal</td>
				<td> <sf:input path="cp" type="text"/> </td>
			</tr>
			<tr>
				<td></td>
				<td> <input type="submit" value="Guardar cambios"/> </td>
			</tr>
		</table>
	</sf:form>
	
	<br>
	<c:out value="${resultado}"></c:out> 
	<br/><br/>
	
<!-- 	Go through the address collection and print address -->
	<c:forEach items="${direcciones}" var="direccion">
		<c:out value="${direccion}"/>
		<br/>
	</c:forEach>
	<br/>
	<a href='<c:url value="/admin" />'> VOLVER ATRAS</a>

</body>
</html>