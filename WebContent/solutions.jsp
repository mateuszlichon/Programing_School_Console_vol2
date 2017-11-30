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
			<td>Data utworzenia</td>
			<td>Ostatnia modyfikacja</td>
			<td>Opis</td>
			<td>Powiazane cwiczenia</td>
			<td>Powiazani uzytkownicy</td>
			<td>Akcje</td>
		</tr>
		<c:forEach var="s" items="${solutions}">
			<tr>
				<td>${s.id}</td>
				<td>${s.created}</td>
				<td>${s.updated}</td>
				<td>${s.description}</td>
				<td>${s.excerciseId}</td>
				<td>${s.usersId}</td>
				<td><a href="UsersByGroup?groupId=${s.id}">Grupa ${s.id}</a></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/WEB-INF/fragments/footer.jspf"%>
</body>
</html>