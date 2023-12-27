<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="com.springbook.biz.board.BoardVO"%>
<%@ page import="com.springbook.biz.user.UserVO"%>
<%@ page import="com.springbook.biz.comment.CommentVO"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%
BoardVO board = (BoardVO) session.getAttribute("board");
CommentVO commentList = (CommentVO) session.getAttribute("commentList");
UserVO user = (UserVO) session.getAttribute("user");
%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>�̴� ������Ʈ</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>



	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="login.jsp">castlejun</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="getBoardList.do">Home</a></li>
					<li><a href="getMyList.do?user=${user }">���� Ȱ��</a></li>
					<li><a href="myInfo.do?user=${user }">���� ����</a></li>
					<li><a href="#">${user.name }</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout.do"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>
			<div class="col-sm-4 text-left">
				<form action="updateBoard.do" method="post">
					<table border="2" cellpadding="0" cellspacing="0" width="600">
						<center>
							<h2>�� ��</h2>
						</center>
						<tr>
							<td bgcolor="WhiteSmoke">��ȣ</td>
							<td><input type="hidden" name="seq"
								value="${board.getSeq()}">${board.getSeq()}</td>
						</tr>
						<tr>
							<td bgcolor="WhiteSmoke">����</td>
							<td><input type="text" name="title" value="${board.title}"></td>
						</tr>
						<tr>
							<td bgcolor="WhiteSmoke">�ۼ���</td>
							<td>${board.writer}</td>
						</tr>
						<tr>
							<td bgcolor="WhiteSmoke">����</td>
							<td><textarea rows="10" cols="40" name="content">${board.content}</textarea></td>
						</tr>
						<tr>
							<td bgcolor="WhiteSmoke">��¥</td>
							<td>${board.regDate }</td>
						</tr>
						<tr>
							<td bgcolor="WhiteSmoke">��ȸ��</td>
							<td>${board.cnt }</td>
						</tr>
						<tr>
							</form>
							<form action="likeBoard.do?seq=${board.getSeq() }" method="post">
								<td bgcolor="WhiteSmoke">��õ��</td>
								<td>${board.b_like }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
									type="submit" value="���ƿ�"></td>
						</tr>
						<tr>
							<td colspan="6" align="center"><input type="submit"
								value="����"></td>
						</tr>

					</table>
				</form>
				<center>
					<c:set var="var1" value="${user.name }" />
					<c:set var="var2" value="${board.writer }" />
					<c:if test="${var1 eq var2 }">
						<br>
						<a href="deleteBoard.do?seq=${board.getSeq()}">�� ����</a>&nbsp;&nbsp;&nbsp;
						</c:if>
					<a href="insertBoard.jsp">�� ���</a>&nbsp;&nbsp;&nbsp; <a
						href="getBoardList.do">�� ���</a>
				</center>
			</div>
			<div class="col-sm-4 text-left">
				<center>
					<h2>���</h2>
				</center>
				<form action="insertComment.do" method="post">
					<table border="2" cellpadding="0" cellspacing="0" width="600">

						<tr>
							<th colspan="3" align="center" bgcolor="WhiteSmoke">��� ���</th>
						</tr>

						<tr>
							<td><input type="hidden" name="seq"
								value="${board.getSeq()}"></td>
							<td><input type="hidden" name="co_nickName"
								value="${user.name }"></td>
							<td><textarea rows="5" cols="50" name="co_content"></textarea></td>
							<td><input type="submit" value="���"></td>
						</tr>
					</table>
				</form>







				<table border="2" cellpadding="0" cellspacing="0" width="600">

					<tr>
						<th colspan="3" align="center" bgcolor="WhiteSmoke">���</th>
					</tr>
					<c:forEach items="${commentList }" var="comment">
						<tr>
							<td>${comment.co_Seq }</td>
							<td>${comment.co_NickName }</td>
							<td>${comment.co_Content }</td>
							<td>${comment.co_RegDate }</td>
						</tr>
					</c:forEach>


				</table>

			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>