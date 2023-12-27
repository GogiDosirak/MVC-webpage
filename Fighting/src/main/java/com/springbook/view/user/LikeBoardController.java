package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.boardImpl.BoardDAO;

public class LikeBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String seq = request.getParameter("seq");
		
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		vo.setSeq(Integer.parseInt(seq));
		boardDAO.likeBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return mav;
		
		
	}
	

}
