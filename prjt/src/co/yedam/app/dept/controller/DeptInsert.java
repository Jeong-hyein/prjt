package co.yedam.app.dept.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.dept.model.DeptDAO;
import co.yedam.app.dept.model.DeptVO;

/**
 * Servlet implementation class DeptInsert
 */
@WebServlet("/DeptInsert.do")
public class DeptInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//등록페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/dept/deptInsert.jsp")
		.forward(request, response);
	}

	//등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		//파라미터 받기
		String deptId = request.getParameter("department_id");
		String deptName = request.getParameter("department_name");
		String magId = request.getParameter("manager_id");
		String locId = request.getParameter("location_id");
		
		//2. 서비스 로직 처리 (DAO)
		DeptDAO dao = new DeptDAO();
		DeptVO dept = new DeptVO();
		dept.setDepartment_id(deptId);
		dept.setDepartment_name(deptName);
		dept.setManager_id(magId);
		dept.setLocation_id(locId);
		dao.deptInsert(dept);
		
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/DeptList.do");
	}

}
