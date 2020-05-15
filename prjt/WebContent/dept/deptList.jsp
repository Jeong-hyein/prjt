<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>deptList.jsp</title>
<jsp:include page ="/common/header.jsp" />
<div><a href="DeptInsert.do">부서 등록</a></div>
<h3>부서목록</h3>
<table border="1">
	<tr>
	<th>부서 아이디</th>
	<th>부서 이름</th>
	<th>매니저 아이디</th>
	<th>지역 아이디</th>
	</tr>
	
	<c:forEach var="vo" items="${list}" >
		<tr>
		<td><a href="DeptUpdate.do?department_id=${vo.department_id}">${vo.department_id}</a></td>
		<td>${vo.department_name}</td>
		<td>${vo.manager_id}</td>
		<td>${vo.location_id}</td>
		</tr>
	</c:forEach>
	
</table>
<jsp:include page="/common/footer.jsp" />

</body>
</html>