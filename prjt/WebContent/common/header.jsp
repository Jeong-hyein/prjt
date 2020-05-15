<%@page import="co.yedam.app.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #666;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 15%;
  min-height: 439px; /* only for demonstration, should be removed */
  background: #ccc;
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
  float: left;
  padding: 20px;
  width: 85%;
  background-color: #f1f1f1;
  min-height: 439px; /* only for demonstration, should be removed */
  height: 100%;
}
section{background: #ccc;}
/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
</style>
</head>
<body>

<header>
  <h2>Cities</h2>
</header>

<section>
  <nav>
    <ul>
      <li>${sessionScope.loginId} (${sessionScope.loginMember.name})님
      <!-- null 체크 다해줌, sessionScope 생략가능, 안적으면 request, session,application 순으로 찾음 p427-->
   	  <%-- 위에랑 같은 결과가 나옴   <%= session.getAttribute("loginMember") !=null ? 
      ((MemberVO) session.getAttribute("loginMember")).getName() : "" %> --%></li> 
      <li><a href="./">메인</a></li>
      
      <!-- /edu/common/menu.jsp의 if를 바꿈 -->
      <c:if test="${loginId == null}">
      <li><a href="MemberLogin.do">로그인</a></li>
      <li><a href="MemberInsert.do">회원가입</a></li>
      
      </c:if>
      
      <c:if test="${loginId != null}">
      <li><a href="MemberLogout.do">로그아웃</a></li>
      <li><a href="MemberUpdate.do">정보수정</a></li>
      </c:if>
      
      <li><a href="BoardList.do">게시판</a></li> <!-- 게시글 목록보이도록 -->
      
      <!-- loginId == 'anmin' -> 사원관리 -->
      <c:if test="${loginId == 'admin'}">
      <li><a href="EmpList.do">사원관리</a></li>
      <li><a href="DeptList.do">부서관리</a></li>
      <li><a href="MemberList.do">회원관리</a></li>
      </c:if>  
    </ul>
  </nav>
  
  <article>