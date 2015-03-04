package com.multicampus.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		// 1. 사용자 입력정보 추출(검색 기능은 나중에...)
		
		// 2. DB 연동
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. 응답 화면 설정
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
		
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

}



