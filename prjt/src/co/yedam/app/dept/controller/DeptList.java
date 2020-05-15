package co.yedam.app.dept.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.emp.model.DeptDAO;
import co.yedam.app.emp.model.DeptVO;


@WebServlet("/DeptList.do")
public class DeptList extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptVO> list = dao.selectAll();
	
		request.setAttribute("list", list);
		request.getRequestDispatcher("/dept/deptList.jsp")
				.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
