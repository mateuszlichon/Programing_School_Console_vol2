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
	<%@ include file="/WEB-INF/fragments/header.jspf"%>
<h1>Dane uzytkownika</h1>
<p>ID uzytkownika: ${user.id}</p>
<p>Imie uzytkownika: ${user.username}</p>
<p>email uzytkownika: ${user.email}</p>
<p>Uzytkownik nalezy do grupy: <a href="UsersByGroup?groupId=${user.userGroupId}">Grupa ${user.userGroupId}</a></p>


	<%@ include file="/WEB-INF/fragments/footer.jspf"%>
</body>
</html>