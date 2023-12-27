package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.userImpl.UserDAO;

public class FindPasswordController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		UserVO vo = new UserVO();
		UserDAO userDAO = new UserDAO();
		vo.setId(id);
		vo.setName(name);
		
		UserVO user = userDAO.findUser(vo);
		
		ModelAndView mav = null;
		if(user!=null) {
			mav = new ModelAndView();
			mav.addObject("user", user);
			mav.setViewName("findPasswordComplete.jsp");
			return mav;
		} else {
			mav = new ModelAndView();
			mav.setViewName("findPassword.jsp");
			return mav;
		}
		
		
	}
	

}
