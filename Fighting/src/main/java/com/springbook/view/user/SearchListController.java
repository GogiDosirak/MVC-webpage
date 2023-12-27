package com.springbook.view.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.boardImpl.BoardDAO;

public class SearchListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		List<BoardVO> boardList = boardDAO.searchList(searchCondition, searchKeyword);

		if (searchKeyword == null || searchKeyword == "") {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("getBoardList.do");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("boardList", boardList);
			mav.setViewName("getBoardList.jsp");
			return mav;
		}

	}

}
