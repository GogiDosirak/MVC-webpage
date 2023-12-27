package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.boardImpl.BoardDAO;
import com.springbook.biz.comment.CommentVO;
import com.springbook.biz.commentImpl.CommentDAO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String seq = request.getParameter("seq");
		String co_Seq = request.getParameter("co_Seq");
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));;
		
		CommentDAO commentDAO = new CommentDAO();
		CommentVO co = new CommentVO();
		co.setSeq(Integer.parseInt(seq));
		
		commentDAO.deleteComment(co);
		boardDAO.deleteBoard(vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return mav;
		
		
	}
	

}
