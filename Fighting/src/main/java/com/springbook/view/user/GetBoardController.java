package com.springbook.view.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.boardImpl.BoardDAO;
import com.springbook.biz.comment.CommentVO;
import com.springbook.biz.commentImpl.CommentDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String seq = request.getParameter("seq");
		
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		vo.setSeq(Integer.parseInt(seq));
		BoardVO board = boardDAO.getBoard(vo);
		boardDAO.cntBoard(vo);
		
		CommentVO co = new CommentVO();
		co.setSeq(Integer.parseInt(seq));
		CommentDAO commentDAO = new CommentDAO();
		List<CommentVO> commentList = commentDAO.getCommentList(co);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.addObject("commentList", commentList);
		mav.setViewName("getBoard.jsp");
		return mav;
		
		
	}
	
	

}
