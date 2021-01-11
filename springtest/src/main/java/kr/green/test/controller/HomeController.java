package kr.green.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.UserService;
import kr.green.test.vo.Uservo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	/* 홈 */
	@RequestMapping(value = "/", method = RequestMethod.GET)		//url이 localhost:8080/test 가 기본 입력 되어있음
	public ModelAndView home(Locale locale, ModelAndView mv) {
		
		mv.setViewName("/main/login");	// 어떠한 jsp와 연결할 것인지 물어보는 메소드
		return mv;
	}
	
	/* 로그인 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)	//url이 localhost:8080/test 가 기본 입력 되어있음
	public ModelAndView loginGet(Locale locale, ModelAndView mv) {
		
		mv.setViewName("/main/login");	// 어떠한 jsp와 연결할 것인지 물어보는 메소드
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(Locale locale, ModelAndView mv, String username, String password) {
		
		System.out.println("id: " + username);
		System.out.println("pw: " + password);
		// 수정 전 : 아이디와 패스워드가 일치하는 회원이 있으면 true, 없으면 false를 가져옴
		// boolean isUser = userService.isUser(username, password);
		// 수정 후 : 아이디와 패스워드가 일치하는 회원이 있으면 회원 정보를 가져오고, 없으면 null을 가져옴
		Uservo isUser = userService.isUser(username, password);
		
		mv.addObject("user", isUser);
		if(isUser != null) {
			mv.setViewName("redirect:/");	// 로그인 성공시 회원이면 메인창으로 보냄
		}else {
			mv.setViewName("redirect:/login");	// 로그인 실패시 회원이 아니면 login창으로 보냄
		}
		return mv;
	}
	
	/* 회원가입 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(Locale locale, ModelAndView mv) {
		
		mv.setViewName("/main/signup");	// 어떠한 jsp와 연결할 것인지 물어보는 메소드
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(Locale locale, ModelAndView mv, Uservo user) {
		
		System.out.println(user);
		
		boolean signup = userService.signup(user);
		System.out.println(signup);
		if(signup) {
			//mv.setViewName("/main/home");	 localhost:8080/test/signup	- url만 그대로고 화면만 home화면 보여주는거
			mv.setViewName("redirect:/");	// localhost:8080/test/			- url이 home으로 바뀜
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	
	/* 로그아웃 */
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(Locale locale, ModelAndView mv, HttpServletRequest r) {
		// 세션에 저장된 유저 정보를 삭제
		r.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");	 
		return mv;
	}
	
	
}
