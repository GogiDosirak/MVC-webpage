<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="EUC-KR">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MemberJoin</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<!-- Custom styles for this template -->
<style>
body {
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
	background-color: #f8f9fa;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
	background-color: #ffffff;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

.form-signin .mb-4 {
	font-size: 2rem;
	color: #495057;
}

.form-signin img {
	width: 60px;
	height: 60px;
	margin-bottom: 20px;
}

.form-signin .form-floating input {
	height: auto;
	margin-bottom: 10px;
	border: none;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .btn-primary {
	background-color: #6c757d;
	border-color: #6c757d;
}

.form-signin .btn-primary:hover {
	background-color: #5a6268;
	border-color: #545b62;
}

.mt-5 {
	margin-top: 3rem !important;
}
</style>
</head>
<body class="text-center">

	<main class="form-signin">
		<form action="findId.do" method="post">
			<img class="mb-4"
				src="https://cdn-icons-png.flaticon.com/512/608/608502.png" alt=""
				width="60" height="60">
			<h1 class="mb-4">아이디 찾기</h1>
			<div class="form-floating">
				<select class="form-control" name="phoneNumber1">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="012">012</option>
				</select> <label for="floatingInput">핸드폰번호(1)</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="phoneNumber2"
					name="phoneNumber2"> <label for="floatingInput">핸드폰번호(2)</label>

			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="email" name="email">
				<label for="floatingInput">email</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">제출</button>
			<br>
			<br>
			<a href="login.jsp">돌아가기</a>
		</form>
	</main>

</body>
</html>