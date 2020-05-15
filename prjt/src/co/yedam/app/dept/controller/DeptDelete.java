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
 * Servlet implementation class DeptDelete
 */
@WebServlet("/DeptDelete.do")
public class DeptDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("department_id");//이름 같아야한다.
		
		DeptDAO dao = new DeptDAO();
		DeptVO vo = new DeptVO();
		vo.setDepartment_id(deptId);
		dao.deptDelete(deptId);

		response.sendRedirect( request.getContextPath() +"/DeptList.do");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
