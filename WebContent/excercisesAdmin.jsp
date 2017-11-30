<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/fragments/header.jspf"%>
	<table>
		<tr>
			<td>ID</td>
			<td>Tytul</td>
			<td>Opis</td>
		</tr>
		<c:forEach var="e" items="${excercises}">
			<tr>
				<td>${e.id}</td>
				<td>${e.title}</td>
				<td>${e.description}</td>
			</tr>
		</c:forEach>
	</table>
	<p>Dodaj nowe cwiczenie</p>
	<form action = 'ExcercisesAdminAdd' method='post'>
		Tytul
		<input type = 'text' name='title' />
		Opis
		<input type = 'text' name='description' />
		<input type='submit' />
	</form>
	<%@ include file="/WEB-INF/fragments/footer.jspf"%>

</body>
</html>