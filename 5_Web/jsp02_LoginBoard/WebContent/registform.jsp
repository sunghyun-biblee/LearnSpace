<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html;	charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idChk(){
		let doc=document.getElementsByName("myid")[0];
		
		if(doc.value.trim()==""|| doc.value==null){ // trim > 좌우 끝의 공백을 제거 / doc.value.trim() == "" > 좌우끝의 공백을 제거하였는데 빈공간일때
			alert("아이디를 입력해주세요")
		
		}else{
			let url="logincontroller.jsp?command=idchk&id="+doc.value.trim();
			// 아이디 중복체크만 할것이기때문에 페이지가 이동되면 안된다 > 1. ajax를 사용 2. 팝업창을 사용
			open(url,"_blank","width=200,heigth=200");
		}
	}
	function idChkConfirm(){
		let chk=document.getElementsByName("myid")[0].title;
		if(chk=='n'){
			alert("아이디 중복체크를 해주세요")
			document.getElementsByName("myid")[0].focus();
		}
		
	}
</script>
</head>
<body>
<h1>회원가입</h1>

<form action="logincontroller.jsp" method="post">
	<input type="hidden" name="command" value="insertuser">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="myid" title="n" required="required"> <!--  required : 필수항목 (꼭 입력해야함) -->
				<input type="button" value="중복체크" onclick="idChk();">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
			<input type="text" name="mypw" required="required" onclick="idChkConfirm();">
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="myname" required="required" onclick="idChkConfirm();">
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" name="myaddr" required="required" onclick="idChkConfirm();">
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>
				<input type="text" name="myphone" required="required" onclick="idChkConfirm();">
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="myemail" required="required" onclick="idChkConfirm();">
			</td>
		</tr>
		<tr>
			<td colspan="2"> <input type="submit" value="가입"> </td>
		</tr>
	</table>
</form>

</body>
</html>