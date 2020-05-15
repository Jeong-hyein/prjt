package co.yedam.app.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.emp.model.DeptDAO;
import co.yedam.app.emp.model.DeptVO;
import co.yedam.app.emp.model.EmpDAO;
import co.yedam.app.emp.model.EmpVO;
import co.yedam.app.emp.model.JobDAO;
import co.yedam.app.emp.model.JobVO;


@WebServlet("/EmpInsert.do")
public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//등록폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//job
		List<JobVO> jobList = JobDAO.getInstance().selectAll();
		request.setAttribute("jobList", jobList);
		//dept
		List<DeptVO> deptList = DeptDAO.getInstance().selectAll();
		request.setAttribute("deptList", deptList);
		//manager(emp)
		List<EmpVO> magList = EmpDAO.getInstance().selectAll();
		request.setAttribute("magList", magList);
		
		request.getRequestDispatcher("emp/empInsert.jsp")
				.forward(request, response);
		
	}

	//등록처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String employeeId = request.getParameter("employee_id");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phoneNum = request.getParameter("phone_number");
		String hireDate = request.getParameter("hire_date");
		String jobId = request.getParameter("job_id");
		String managerId = request.getParameter("manager_id");
		String departmentId = request.getParameter("department_id");
		//2. DAO insert
		EmpDAO empDAO = new EmpDAO();
		EmpVO empVO = new EmpVO();
		empVO.setEmployee_id(employeeId);
		empVO.setFirst_name(firstName);
		empVO.setLast_name(lastName);
		empVO.setEmail(email);
		empVO.setPhone_number(phoneNum);
		empVO.setHire_date(hireDate);
		empVO.setJob_id(jobId);
		empVO.setManager_id(managerId);
		empVO.setDepartment_id(departmentId);
		empDAO.insert(empVO);
		//3. 목록 서블릿 deirect
		response.sendRedirect("/edu/EmpList.do");
		
	}

}
