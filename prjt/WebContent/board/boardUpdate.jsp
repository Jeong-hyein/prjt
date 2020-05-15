<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page ="/common/header.jsp" />
<h1>게시판 수정 페이지</h1>
<form action="BoardUpdate.do"" method="post">
	<input name="seq" value="${board.seq}" type="hidden"/>
	<!-- 작성자 : <input type="text" name="id" id="id" /><br/> -->
	작성자: <input name="id" value="${board.id}"><br> <!--null 빼려고, <=session.getAttribute("loginId")%> 대신 ${loginId}넣음  -->
	제목 : <input type="text" name="title" id="title" value="${board.title}" /><br/>
	내용 : <br>
	<textarea rows="10" cols="30" name="contents" id="contents" >${board.contents}</textarea><br/>
	
	<button>등록</button>
	<button><a href="BoardDelete.do?seq=${board.seq}">삭제</a></button>
</form>
<jsp:include page="/common/footer.jsp" />
</body>
</html>