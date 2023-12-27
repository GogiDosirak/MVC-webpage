package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.userDetail.UserDetailVO;
import com.springbook.biz.userDetailImpl.UserDetailDAO;
import com.springbook.biz.userImpl.UserDAO;

public class MemberJoinController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		String nickNmae = request.getParameter("name");
		String phoneNumber1 = request.getParameter("phoneNumber1");
		String phoneNumber2 = request.getParameter("phoneNumber2");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		UserDAO userDAO = new UserDAO();
		UserVO vo = new UserVO();
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		UserDetailVO detailVO = new UserDetailVO();
		
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setRole(role);
		vo.setNickName(nickNmae);
		detailVO.setId(id);
		detailVO.setPhoneNumber1(phoneNumber1);
		detailVO.setPhoneNumber2(phoneNumber2);
		detailVO.setAddress(address);
		detailVO.setEmail(email);
		
		userDAO.insertUser(vo);
		userDetailDAO.insertUserDetail(detailVO);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp");
		return mav;
		
		
		
		
		
	}
	

}
