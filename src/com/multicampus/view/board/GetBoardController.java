package com.multicampus.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		// 1. 사용자 입력정보(seq) 추출
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		// 2. DB 연동
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. 응답 화면 구성
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
		
		mav.setViewName("getBoard.jsp");
		mav.addObject("board", board);
		
		return mav;
	}

}
