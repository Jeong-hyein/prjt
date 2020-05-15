package co.yedam.app.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.board.model.BoardDAO;
import co.yedam.app.board.model.BoardVO;



/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.getBoardList();
	
		request.setAttribute("list", list);
		request.getRequestDispatcher("/board/boardList.jsp")
		.forward(request, response);
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
