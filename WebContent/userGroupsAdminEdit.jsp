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

	<p>Edytuj grupe o ID ${id}</p>
	<form action = 'UserGroupsAdminEdit' method='post'>
		Nazwa
		<input type = 'text' name='name' />
		<input type = 'text' name='id' value='${id}' /> 
		<input type = 'submit' />
	</form>
	<%@ include file="/WEB-INF/fragments/footerAdmin.jspf"%>
</body>
</html>