package co.yedam.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.app.member.model.MemberDAO;
import co.yedam.app.member.model.MemberVO;

//p227
@WebServlet("/MemberLogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2. 서비스 로직
		MemberDAO dao = new MemberDAO();
		dao.getMember(id); //단건조회
		MemberVO vo = dao.getMember(id);
		
		response.setContentType("text/html; charset=utf-8"); //=하고 공백주면 안된다.
		PrintWriter out = response.getWriter();
		
		//id 조회결과 없으면 id 없다.
		if(vo.getId() == null) { //id 오류, isEmpty(): 없다는 뜻
			request.setAttribute("errorMsg", "id 오류");
			request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);;
		}else if(! vo.getPwd().equals(pwd)) { //조회되면 pwd 검사해서 틀리면 pwd 오류, equals가 아니라면
			request.setAttribute("errorMsg", "pwd 오류"); //errorMsg: 속성
			request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);;
		} else { //login ok, 다 맞으면 로그인
//			out.print("로그인 성공");
			//세션에 로그인 여부를 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id); //"loginId"는 내가 지정
			session.setAttribute("loginMember", vo); //object 타입이라서 전체 저장가능,vo객체가 들어가있음.
			response.sendRedirect(request.getContextPath() + "/"); //main 페이지로 보낸다.
		}
		//3. 결과 저장
		
		
		//4. 뷰페잊로 포워드
		
	}

	//로그인 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 페이지로 포워드
		request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
	}

}
