<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="pl.coderslab.model.SolutionDto"%>
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
			<td>Tytul zadania</td>
			<td>Autor rozwiazania</td>
			<td>Data dodania</td>
			<td>Akcje</td>
		</tr>
		<c:forEach var="s" items="${solutions}">
			<tr>
				<td>${s.excerciseTitle}</td>
				<td>${s.userName}</td>
				<td>${s.creationDate}</td>
				<td><a href="SolutionById?solutionId=${s.solutionId}">szczegoly</a></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/WEB-INF/fragments/footer.jspf"%>
</body>
</html>