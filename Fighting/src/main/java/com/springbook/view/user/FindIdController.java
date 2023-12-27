package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.userDetail.UserDetailVO;
import com.springbook.biz.userDetailImpl.UserDetailDAO;
import com.springbook.biz.userImpl.UserDAO;

public class FindIdController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phoneNumber1 = request.getParameter("phoneNumber1");
		String phoneNumber2 = request.getParameter("phoneNumber2");
		String email = request.getParameter("email");
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		UserDetailVO detailVO = new UserDetailVO();
		
		detailVO.setPhoneNumber1(phoneNumber1);
		detailVO.setPhoneNumber2(phoneNumber2);
		detailVO.setEmail(email);
		
		UserDetailVO userDetail = userDetailDAO.findUserId(detailVO);
		
		ModelAndView mav = null;
		if(userDetail != null) {
			mav = new ModelAndView();
			mav.addObject("userDetail", userDetail);
			mav.setViewName("findIdComplete.jsp");
			return mav;
		} else { 
			mav = new ModelAndView();
			mav.setViewName("findId.jsp");
			return mav;
		}
			
			
		}
			
		
		
		
		
		

	

}
