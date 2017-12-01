<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="pl.coderslab.model.User"%>
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
			<td>Imie</td>
			<td>e-mail</td>
			<td>Akcje</td>
		</tr>
		<c:forEach var="u" items="${users}">
			<tr>
				<td>${u.id}</td>
				<td>${u.username}</td>
				<td>${u.email}</td>
				<td><a href="UsersByGroup?groupId=${u.userGroupId}">Grupa ${u.userGroupId}</a></td>
				<td><a href="UsersAdminDelete?id=${u.id}">Usun uzytkownika</a></td>
				<td><a href="UsersAdminEdit?id=${u.id}">Edytuj uzytkownika</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>Dodaj uzytkownika</p>
	<form action = 'UsersAdminAdd' method='post'>
		Nazwa
		<input type = 'text' name='name' />
		email
		<input type = 'text' name='email' />
		haslo
		<input type = 'text' name='password' />
		numer grupy
		<select name="groupId">
		<c:forEach var="g" items="${groups}">
			<option value="${g.id}">${g.name}</option>
		</c:forEach>
		</select>
		<input type='submit' />
	</form>
	<%@ include file="/WEB-INF/fragments/footerAdmin.jspf"%>
</body>
</html>