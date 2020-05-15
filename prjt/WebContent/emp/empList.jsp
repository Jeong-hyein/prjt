<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title> prjt/empList.jsp </title>
<jsp:include page ="/common/header.jsp" />

<h3>사원목록</h3>
<form name="searchfrm"> <!-- action 없으면 조건을 가지고 현재페이지 다시 부르는거. -->
	<input name="p" value="1" type="hidden">
	부서검색: <select name="department_id">
				<option value="">전체 </option>
				<option value="10">Administration
				<option value="20">Marketing
				<option value="50">Shipping
			</select>
	이름: <input name="first_name">
	<button>검색</button>
</form>

<table border="1">
	<tr>
	<th>사번</th>
	<th>이름</th>
	<th>이메일</th>
	<th>폰번호</th>
	<th>입사날짜</th>
	<th>직업이름</th>
	<th>급여</th>
	<th>커미션 비율</th>
	<th>매니저 아이디</th>
	<th>부서 아이디</th>
	</tr>
	<c:forEach var="vo" items="${list}" >
		<tr>
		<td>${vo.employee_id}</td> <!-- employee_id가  getEmployee_id()를 부름 getEmployee_id가 없으면 에러 -->
		<td>${vo.first_name} ${vo.last_name }</td>
		<td>${vo.email}</td>
		<td>${vo.phone_number}</td>
		<td>${vo.hire_date}</td>
		<td>${vo.job_id}</td>
		<td>${vo.salary}</td>
		<td>${vo.commission_pct}</td>
		<td>${vo.manager_id}</td>
		<td>${vo.department_id}</td>
		</tr>
	</c:forEach>

</table>
<script>
	function gopage(p) { //document.searchfrm하면 searchfrm을 찾아간다.
		document.searchfrm.p.value = p; //폼에 p값을 담는다.
		document.searchfrm.submit(); //폼 전체를 전송
	}
</script>
<my:paging paging="${paging}" jsfunc="gopage"/> <!-- 페이지 번호 나오게 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>