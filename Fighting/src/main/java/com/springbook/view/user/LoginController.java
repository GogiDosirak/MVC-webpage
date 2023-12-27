package com.springbook.view.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.userImpl.UserDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			mav.setViewName("getBoardList.do");
		} else {
			mav.setViewName("login.jsp");
		}
		return mav;
		
		
		
	}
	
	

}
