package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.boardImpl.BoardDAO;

public class InsertBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");

		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		

		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		boardDAO.insertBoard(vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return mav; 
	}
	
	

}
