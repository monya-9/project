<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<h3>회원 전체조회</h3>
	<form method="post" name="frm" id="frm" action="memberSelectAllServ" >
	<table id="members">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>닉네임</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>성별</th>
		</tr>
		<c:forEach items="${list }" var="member">
		<tr>
			<td><a href="">${member2.member_id}</a></td>
			<td>${ member.member_pw() }</td>
			<td>${ member.nickname() }</td>
			<td>${ member.member_tel() }</td>
			<td>${ member.member_email() }</td>
			<td>${ member.gender() }</td>
		</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>