<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/fragments/header.jspf"%>
<h3>Zle haslo. Sprobuj ponownie badz na panelu uzytkownika.</h3>
	<form action = 'AdminVerification' method='post'>
		Haslo administratora
		<input type = 'text' name='verPassword' />
		<input type='submit' />
	</form>
	<%@ include file="/WEB-INF/fragments/footer.jspf"%>

</body>
</html>