<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>deptUpdate.jsp</title>
<jsp:include page ="/common/header.jsp" />
<h1>부서 수정 페이지</h1>
<form action="DeptUpdate.do"" method="post">
	부서 아이디: <input name="department_id" id="department_id" value="${dept.department_id}" /><br/>
	부서 이름: <input type="text" name="department_name" id="department_name" value="${dept.department_name}" /><br/>
	매니저 아이디: <input name="manager_id" id="manager_id" value="${dept.manager_id}"/><br/>
	지역 아이디: <input name="location_id" id="location_id" value="${dept.location_id}"/><br/>
	
	<button>등록</button>
	<button><a href="DeptDelete.do?department_id=${dept.department_id}">삭제</a></button>
</form>
<jsp:include page="/common/footer.jsp" />

</body>
</html>