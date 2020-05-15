package co.yedam.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.member.model.MemberDAO;
import co.yedam.app.member.model.MemberVO;

/**
 * Servlet implementation class MemberUpdateForm
 */

//@WebServlet("/MemberUpdateForm.do")
@WebServlet("/MemberUpdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	//수정페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기, 수정할 회원아이디 받기
//		String id = request.getParameter("id");
		//로그인 된걸 받아옴, session에서 id 가져오기
		String id = (String) request.getSession().getAttribute("loginId"); //이름 같아야한다.
		if(id == null) {    	// /prjt가 들어가야하는데 바뀔수도 있기때문에 request....을 써준다.
			response.sendRedirect(request.getContextPath()+"/MemberLogin.do");
			return;
		} 
		
		//서비스 로직 처리(회원정보 1건 조회)
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);
		
		//결과 저장
		request.setAttribute("member", vo);
		
		//뷰페이지로 이동, request객체를 넘겨줘야하기 때문에 forward
		request.getRequestDispatcher("/member/memberUpdate.jsp")
				.forward(request, response);
	}
	
	
	//수정처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		//1. 파라미터 받기
		String id = request.getParameter("id"); //name속성이 파라미터
		String pwd = request.getParameter("pwd"); 
		String name = request.getParameter("name");
		String[] hobby = request.getParameterValues("hobby"); //값을 받아와서 배열로 만든다. p148
		String hobbys = "";
		if(hobby != null) {
			for(String temp : hobby) {
				hobbys += temp + ",";
			}
		}
		String gender = request.getParameter("gender");
		String religion = request.getParameter("religion");
		String introduction = request.getParameter("introduction");		
		
		//2. 서비스 로직 처리 (DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setHobby(hobbys);
		member.setGender(gender);
		member.setReligion(religion);
		member.setIntroduction(introduction);
		int r = memberDAO.memberUpdate(member);
		
		//3. 결과 출력
		PrintWriter out = response.getWriter();
		out.print("<br>id = " + id);
		out.append("<br>pwd = " + pwd);
		out.append("<br>name = " + name);
		out.append("<br>hobbys = " + hobbys);
		out.append("<br>gender = " + gender);
		out.append("<br>religion = " + religion);
		out.append("<br>introduction = " + introduction);
		out.print("<br> 처리된 건수= " + r);
		
	}
	


}
