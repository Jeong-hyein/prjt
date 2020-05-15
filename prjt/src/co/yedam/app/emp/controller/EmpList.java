package co.yedam.app.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.common.Paging;
import co.yedam.app.emp.model.EmpDAO;
import co.yedam.app.emp.model.EmpVO;


@WebServlet("/EmpList.do")
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		
		
		//1. 파라미터
		
		//페이징 처리(추가로 들어간거)
		//현재 페이지 파라미터 받기
		String strPage = request.getParameter("p"); //페이지 번호 파라미터로 받음
		int p = 1;
		if(strPage != null && !strPage.isEmpty()) { //페이지 파라미터를 안받아오면 1로 받아왓으면 받아온값으로
			p = Integer.parseInt(strPage);
		}
		
		//페이징 객체를 생성
		Paging paging = new Paging();
		paging.setPageUnit(5);	 	//한페이지에 출력할 레코드 건수, 생략시 10(디폴트가 10),(옵션: 생략가능)
		paging.setPageSize(3);		//한페이지 출력할 페이지 번호 수(옵션: 생략가능) 
		paging.setPage(p);			//현재페이지(필수)
		paging.setTotalRecord(140); //전체 레코드 건수 조회(필수)
		paging.setTotalRecord(dao.getCount());
		request.setAttribute("paging", paging);
		
		
		//서비스(DAO 목록조회)
		//범위에 있는것만 출력하기 위해
		int start = paging.getFirst();
		int end = paging.getLast();
		
		String department_id = request.getParameter("department_id");
		String first_name = request.getParameter("first_name");
		
		List<EmpVO> list = dao.selectAll(start, end, department_id, first_name);
		
		//3.결과 출력(out.print) or 결과저장해서 view forward
		request.setAttribute("list", list);
		request.getRequestDispatcher("emp/empList.jsp")
				.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
