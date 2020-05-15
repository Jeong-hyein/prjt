package co.yedam.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.member.model.MemberDAO;
import co.yedam.app.member.model.MemberVO;

@WebServlet("/MemberInsert.do") //memberinsert.jsp 랑 맞아야 한다.
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//회원가입 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//무조건 하고 시작. 아니면 한글 다 깨진다.
		//응답결과 인코딩
		//application/octet-stream 파일 다운받아짐, 타입을 잘 지정해야함
		response.setContentType("text/html; charset=UTF-8");
		//요청정보(파라미터) 인코딩
		request.setCharacterEncoding("utf-8");
		
		//1. 파라미터 받기
		String id = request.getParameter("id"); //name속성이 파라미터
		String pwd = request.getParameter("pwd"); 
		//이름, 취미, 종교, 자기소개
		String name = request.getParameter("name");
//		String hobby = request.getParameter("hobby");
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
		
//		PrintWriter out = response.getWriter();
//		response.getWriter().append("<br>id = " + id)
//		out.append("<br>id = " + id)
//			.append("<br>pwd = " + pwd)
//			.append("<br>name = " + name)
////			.append("<br>hobby = " + hobby) 여러개 안 나옴
//			.append("<br>취미 = " + hobbys)
//			.append("<br>religion = " + religion)
//			.append("<br>introduction = " + introduction);
//		out.print("<br>id = " + id);
//		out.append("<br>pwd = " + pwd);
//		out.append("<br>취미 = " + hobbys);
		
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
		int r = memberDAO.memberInsert(member);
		
		//3. 결과 출력
//		PrintWriter out = response.getWriter();
//		out.print("<br>id = " + id);
//		out.append("<br>pwd = " + pwd);
//		out.append("<br>name = " + name);
//		out.append("<br>hobbys = " + hobbys);
//		out.append("<br>gender = " + gender);
//		out.append("<br>religion = " + religion);
//		out.append("<br>introduction = " + introduction);
//		out.print("<br> 처리된 건수= " + r);
		
		//3. 회원목록으로 이동 //include, forwaed, sendRedirect
		//경로 다름 주의!, 페이지만 바뀌면 된다, request객체 필요없음.: send
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/MemberList.do");
//		request.getRequestDispatcher("/MemberList.do").forward(request, response);

		
	}
	
	//회원가입 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입 페이지로 포워드
		request.getRequestDispatcher("/member/memberInsert.jsp").forward(request, response);
	}
}
