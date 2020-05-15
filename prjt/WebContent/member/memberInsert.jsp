<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>prjt/memberInsert.jsp</title>
<script>
	function validCheck() {
		//text 필수입력 체크, 필수입력 체크
		if(frm.id.value == ""){ //window.document 생략, //trim함수(공백입력 체크인듯?)
			alert("id 입력");
			frm.id.focus();
			return;
		}
		if(frm.pwd.value == ""){ //window.document 생략
			alert("pwd 입력");
			frm.pwd.focus();
			return;
		}
		if(frm.name.value == ""){ //window.document 생략
			alert("name 입력");
			frm.name.focus();
			return;
		}
		//체크박스
/* 		hobby=document.getElementsByName("hobby");
		var cnt = 0;
		for(i=0; i<hobby.length; i++){
			if(hobby[i].checked == true) {
				cnt++;
			}
		}*/
		var cnt = document.querySelectorAll("input[name=hobby]:checked"); //name=hobby인것중 체크된거만 가져옴,input생략가능
		if(cnt == 0) {
			alert("취미 적어도 1개 선택");
			return;
		} 
		
 		gender = document.getElementsByName("gender");
		cnt = 0;
		for(i=0; i<gender.length; i++){
			if(gender[i].checked == true) {
				cnt++;
			}
		}
		if(cnt == 0) {
			alert("성별 선택");
			return;
		}		 
		
		//select
		if(frm.religion.selectIndex < 1) { //-1
			alert("종교 선택");
			return; //오류나면 return
		}
		frm.submit(); //에러가 안나면 결과를 전송
	}
</script>
<%@include file ="/common/header.jsp" %>
<h3>회원 정보</h3>
<form name="frm" action="MemberInsert.do" method="post">
	ID : <input type="text" name="id" id="id" /><br/>
	비밀번호 : <input type="password" name="pwd" id="pwd" /><br/>
	이름 : <input type="text" name="name" id="name" /><br/>
	취미 :
		<input type="checkbox" name="hobby" id="hobby1" value="h01" /> 등산
		<input type="checkbox" name="hobby" id="hobby2" value="h02" /> 운동
		<input type="checkbox" name="hobby" id="hobby3" value="h03" /> 독서
		<input type="checkbox" name="hobby" id="hobby4" value="h04" /> 여행 <br/>
	성별 :
		<input type="radio" name="gender" value="m" /> 남자
		<input type="radio" name="gender" value="f" /> 여자 <br/>
	종교 :
		<select name="religion" id="religion">
			<option value="">--선택--
			<option value="r01" > 기독교
			<option value="r02" > 불교
			<option value="r03" > 천주교
			<option value="r04" > 무교
		</select> <br/>
	자기소개: <br/>
		<textarea rows="10" cols="30" name="introduction" id="introduction"></textarea><br/>
		
	<button type="button" onclick="validCheck()">회원가입</button>
	<input type="reset" value="지우기" />

</form>
<%@include file="/common/footer.jsp" %>
</body>
</html>