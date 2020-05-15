<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page ="/common/header.jsp" />
<h1>부서 등록 페이지</h1>
<form action="DeptInsert.do"" method="post">
	부서 아이디: <input name="department_id" id="department_id" /><br/>
	부서 이름: <input type="text" name="department_name" id="department_name" /><br/>
	매니저 아이디: <input name="manager_id" id="manager_id" /><br/>
	지역 아이디: <input name="location_id" id="location_id" /><br/>
	
	<input type="submit" value="등록" />
	<input type="reset" value="지우기" />
</form>
<jsp:include page="/common/footer.jsp" />
</body>
</html>