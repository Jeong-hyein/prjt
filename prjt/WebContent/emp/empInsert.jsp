<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>prjt/empInsert.jsp</title>
<style>
.label { display: inline-block; width: 180px;  }
</style>
<script>
   function validCheck(){
      //필수입력체크
      //textfield
      if(frm.employee_id.value == ""){
         alert("id 입력");
         frm.employee_id.focus();
         return;
      }
      frm.submit();
   }
</script>
<jsp:include page="/common/header.jsp"/>
<h3 id="top">사원등록</h3>
<form action="EmpInsert.do" method="post" name="frm">
   <div><span class="label">employee_id</span><input type="number" min="300" step="1" name="employee_id"></div>
   <div><span class="label">first_name</span><input name="first_name"></div>
   <div><span class="label">last_name</span><input name="last_name"></div>
   <div><span class="label">email</span><input type="email" name="email"></div>
   <div><span class="label">phone_number</span><input type="text" name="phone_number"></div>
   <div><span class="label">hire_date</span><input type="date" name="hire_date"></div>
   <div>
      <span class="label">job_id</span> 
      <select name="job_id">
         <c:forEach items="${jobList}" var="jobL">
            <option value="${jobL.job_id}">${jobL.job_title} 
         </c:forEach>
      </select>
   </div> 
   <div>
      <span class="label">department_id</span> <br>
      <c:forEach items="${deptList}" var="deptL">
         <input type="radio" name="department_id" value="${deptL.department_id}"> ${deptL.department_name}
      </c:forEach>
   </div>
   <div>
      <span class="label">manager_id</span> 
      <select name="manager_id">
         <c:forEach items="${empList}" var="empL">
            <option value="${empL.manager_id}">${empL.first_name} ${emp.last_name}
         </c:forEach>
      </select>
   </div>
   <div>
      <button type="button" onclick="validCheck()">등록</button>
      <button type="reset">초기화 </button>
   </div>
</form>

</body>
</html>