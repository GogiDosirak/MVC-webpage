package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.userDetail.UserDetailVO;
import com.springbook.biz.userDetailImpl.UserDetailDAO;
import com.springbook.biz.userImpl.UserDAO;

public class MyInfoController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserVO users = (UserVO)session.getAttribute("user");
		String id = users.getId();
		String password = users.getPassword();
		
		
		UserVO vo = new UserVO();
		UserDetailVO detailVO = new UserDetailVO();
		UserDAO userDAO = new UserDAO();
		UserDetailDAO detailDAO = new UserDetailDAO();
		
		vo.setId(id);
		vo.setPassword(password);
		detailVO.setId(id);
		
		
		UserVO user = userDAO.getUser(vo);
		UserDetailVO userDetail = detailDAO.getUserDetail(detailVO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		mav.addObject("userDetail", userDetail);
		mav.setViewName("myInfo.jsp");
		return mav;
		
		
		
	}
	

}
