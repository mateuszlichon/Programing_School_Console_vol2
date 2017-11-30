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
	<%@ include file="/WEB-INF/fragments/headerAdmin.jspf"%>
	<table>
		<tr>
			<td>ID</td>
			<td>Data utworzenia</td>
			<td>Ostatnia modyfikacja</td>
			<td>Opis</td>
			<td>Powiazane cwiczenia</td>
			<td>Powiazani uzytkownicy</td>
		</tr>
		<c:forEach var="s" items="${solutions}">
			<tr>
				<td>${s.id}</td>
				<td>${s.created}</td>
				<td>${s.updated}</td>
				<td>${s.description}</td>
				<td><a href="ExcerciseById?excerciseId=${s.excerciseId}">Cwiczenie o ID ${s.excerciseId}</a></td>
				<td><a href="UserById?userId=${s.usersId}">Uzytkownik od ID ${s.usersId}</a></td>
			</tr>
		</c:forEach>
	</table>
		<p>Dodaj rozwiazanie</p>
	<form action = 'SolutionsAdminAdd' method='post'>
		Data utworzenia
		<input type = 'date' name='created' />
		Data modyfikacji
		<input type = 'date' name='updated' />
		Opis
		<input type = 'text' name='description' />
		ID powiazanego cwiczenia
		<input type = 'number' name='excerciseId' />
		ID autora
		<input type = 'number' name='usersId' />		
		<input type='submit' />
	</form>
	<%@ include file="/WEB-INF/fragments/footerAdmin.jspf"%>
</body>
</html>