package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.comment.CommentVO;
import com.springbook.biz.commentImpl.CommentDAO;

public class InsertCommentController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String co_nickName = request.getParameter("co_nickName");
		String co_content = request.getParameter("co_content");
		String seq = request.getParameter("seq");
		CommentVO vo = new CommentVO();
		CommentDAO commentDAO = new CommentDAO();
		vo.setCo_Content(co_content);
		vo.setCo_NickName(co_nickName);
		vo.setSeq(Integer.parseInt(seq));
		commentDAO.insertComment(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoard.do");
		return mav;
		
		
	}
	

}
