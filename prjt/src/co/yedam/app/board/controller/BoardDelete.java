package co.yedam.app.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.board.model.BoardDAO;
import co.yedam.app.board.model.BoardVO;

/**
 * Servlet implementation class BoardDelete
 */
@WebServlet("/BoardDelete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");//이름 같아야한다.
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		dao.boardDelete(vo);

		response.sendRedirect( request.getContextPath() +"/BoardList.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
