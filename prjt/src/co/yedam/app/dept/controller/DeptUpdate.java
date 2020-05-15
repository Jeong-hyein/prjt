package co.yedam.app.dept.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.board.model.BoardDAO;
import co.yedam.app.board.model.BoardVO;
import co.yedam.app.dept.model.DeptDAO;
import co.yedam.app.dept.model.DeptVO;

/**
 * Servlet implementation class DeptUpdate
 */
@WebServlet("/DeptUpdate.do")
public class DeptUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//수정페이지
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("department_id");
		DeptDAO dao = new DeptDAO();
		DeptVO vo = dao.getDept(deptId);	
		request.setAttribute("dept", vo);
		request.getRequestDispatcher("/dept/deptUpdate.jsp").forward(request, response);
	}

	//수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
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
		dao.deptUpdate(dept);
		
		request.setAttribute("dept",dept);
		
		response.sendRedirect( request.getContextPath() +"/DeptList.do");
	}

}
