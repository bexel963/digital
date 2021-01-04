package kr.green.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//url이 localhost:8080/test 가 기본 입력 되어있음
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, ModelAndView mv) {
		
		//abcd1234의 이메일을 가져옴
		String id = "abcd1234";
		String email = userService.getEmail(id);
		Uservo user = userService.getUser(id);
		System.out.println(email);
		System.out.println(user);
		mv.setViewName("/main/home");	// 어떠한 jsp와 연결할 것인지 물어보는 메소드
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
		
		boolean isUser = userService.isUser(username, password);	// 회원인지 아닌지를 물어보는 메소드
		System.out.println("결과 : " + isUser);
		
		mv.setViewName("/main/login");	// 어떠한 jsp와 연결할 것인지 물어보는 메소드
		if(isUser) {
			mv.setViewName("redirect:/");	// 회원이면 메인창으로 보냄
		}else {
			mv.setViewName("redirect:/login");	// 회원이 아니면 login창으로 보냄
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
		mv.setViewName("/main/signup");	// 어떠한 jsp와 연결할 것인지 물어보는 메소드
		return mv;
	}
}
