package com.springbook.view.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.boardImpl.BoardDAO;


public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList.jsp");
		return mav;
		
		
		
		
	}

}
