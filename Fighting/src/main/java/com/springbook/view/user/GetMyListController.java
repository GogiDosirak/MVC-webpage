package com.springbook.view.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.boardImpl.BoardDAO;
import com.springbook.biz.user.UserVO;

public class GetMyListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		String writer = user.getName();
		
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setWriter(writer);
		
		List<BoardVO> boardList = boardDAO.getMyList(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList.jsp");
		return mav;
		
		
	}
	

}
