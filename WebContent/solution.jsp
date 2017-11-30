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
	<h1>Szczegoly rozwiazania</h1>
	<p>Numer identyfikacyjny rozwiazania: ${solution.id}</p>
	<p>Data stworzenia rozwiazania: ${solution.created}</p>
	<p>Data ostatniej modyfikazji: ${solution.updated}</p>
	<p>Opis rozwiazania: ${solution.description}</p>
	<p>
		<a href="ExcerciseById?excerciseId=${solution.excerciseId}">Link do
			cwiczenia (do dokonczenia!!!)</a>
	</p>
	<p>
		<a href="UserById?userId=${solution.usersId}">Link do uzytkownika</a>
	</p>
	<%@ include file="/WEB-INF/fragments/footer.jspf"%>
</body>
</html>