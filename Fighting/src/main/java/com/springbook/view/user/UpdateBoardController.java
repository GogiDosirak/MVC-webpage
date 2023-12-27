package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.boardImpl.BoardDAO;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setTitle(title);
		vo.setContent(content);
		boardDAO.updateBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return mav;
	}
	

}
