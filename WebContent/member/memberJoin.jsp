<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 Class="page_title">회원 가입</h3>
	<form method="post" name="frm" id="frm" action="MemberJoinServ" >
		<div>
			<label for="id">아이디:</label>
			<input type="text" id="id" name="id"><br>
		</div>
		<div>
			<label for="pw">비밀번호:</label>
			<input type="password"id="pw" name="pw"><br>
		</div>
		<div>
			<label for="nickname">필명:</label>
			<input id="nickname"name="nickname"></input><br>
		</div>
		<div>
			<label for="tel">전화번호:</label>
			<input type="text" id="tel" name="tel"><br>
		</div>
		<div>
			<label for="email">이메일:</label>
			<input type="text" id="emaile" name="emaile"><br>
		</div>
		<div>
			<label for="gender">성별:</label>
			<input type="radio" id="male"name="gender" value="male">
				<label for="male">남</label>
				<input type="radio" id="female" name="gender" value="female">
				<label for="female">여</label><br>
		</div>
		<div>
			<button>등록</button>
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>