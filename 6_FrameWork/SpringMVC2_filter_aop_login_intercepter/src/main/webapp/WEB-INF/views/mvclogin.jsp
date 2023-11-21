<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#loginChk").hide();	
	})
	function login(){
		let memberid=$("#memberid").val().trim();//val() > 해당 id값을 데이터를 가져옴
		let memberpw=$("#memberpw").val().trim();//trim() > 양쪽끝 공백을 지움
		let loginVal={"memberid": memberid, "memberpw":memberpw} //json 데이터 형식 / :(콜론)을 기준으로 키와 벨류를 나눠서 저장
		
		if( memberid == null || memberid == "" || memberpw == null || memberpw == "" ){
			alert("ID 와 비밀번호를 확인해 주세요")
		} else{
			$.ajax({
				url: "ajaxlogin.do",// 통신하고자 하는 url 주소(필수)
				type: "post",	//get,post 등의 통신 방식을 지정
				data: JSON.stringify(loginVal),	// 서버로 보내는 데이터
				contentType:"application/json", // 서버로 보내는 데이터의 타입을 명시
				datatype:"json", // 서버에서 반환되는 데이터의 타입 (데이터를 받을때 타입)
				success:function(msg){
					if(msg.check==true){
						location.href="list.do";
					}else{
						$("#loginChk").show();
						$("#loginChk").html("ID 혹은 PW가 잘못되었습니다.")
					}
				},
				error:function(){
					alert("통신 실패")
				}
			});
		}
	}
</script>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid"> </td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" id="memberpw"> </td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="login" onclick="login()"> </td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>
</body>
</html>