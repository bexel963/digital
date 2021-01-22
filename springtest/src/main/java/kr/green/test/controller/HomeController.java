package kr.green.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.UserService;
import kr.green.test.vo.TestVo;
import kr.green.test.vo.Uservo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	/* 메일 보내기 */
	@Autowired
	private JavaMailSender mailSender;
	
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
	/* 비밀번호 찾기(메일) */
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@RequestMapping(value = "/find/pw", method = RequestMethod.POST)
	@ResponseBody
	public Object searchPwGet(@RequestBody Uservo user) {	
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		System.out.println("login.jsp에서 받아온 id : " + user.getId());
		Uservo getUser = userService.getUser(user.getId());
		System.out.println("DB에 요청한 user정보 : " + getUser);
		if( getUser != null ) {
			String newPw = "1234";
			String encPw = passwordEncoder.encode(newPw);
			getUser.setPw(encPw);
			userService.updateUser(getUser);
			
			String setfrom = "stajun@naver.com";         
		    String tomail  = getUser.getEmail();     // 받는 사람 이메일
		    String title   = "비밀번호 찾기";      // 제목
		    String content = "새 비밀번호 : " + newPw;    // 내용

		    try {
		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

		        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
		        messageHelper.setTo(tomail);     // 받는사람 이메일
		        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
		        messageHelper.setText(content);  // 메일 내용

		        mailSender.send(message);
		    } catch(Exception e){
		        System.out.println(e);
		        map.put("result", "fail");
		    }
		    map.put("result", "success");

		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	/* list2 - 회원정보 리스트 */
	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	public ModelAndView userListGet(ModelAndView mv) {
		ArrayList<Uservo> list = new ArrayList<Uservo>();
		//모든 회원 정보를 가져오는 코드
		list = userService.getAllUser();
		mv.addObject("list",list);
		mv.setViewName("/board/list2");
		return mv;
	}
	/* list2 내용 수정 - 회원정보 리스트 수정 */
	@RequestMapping(value = "/author/modify", method = RequestMethod.POST)		//url이 localhost:8080/spring 가 기본 입력 되어있음
	@ResponseBody
	// 리턴타입을 Object로 하면 아무거다 다 리턴 할수있다.
	public Object authorModifyPost(@RequestBody Uservo userVo) {	
		userService.updateAuthor(userVo);
		// json형태로 보내주는거는 map으로 보내주는거다.
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		return map;
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
	/* 아이디 중복검사 */
	@RequestMapping(value = "/dup", method = RequestMethod.POST)		
	@ResponseBody
	public String dupPost(String id) {
		Uservo user = userService.getUser(id);
		if(user == null)
			return "not user";
		return "user";
	}
	
	/* 로그아웃 */
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(Locale locale, ModelAndView mv, HttpServletRequest r) {
		// 세션에 저장된 유저 정보를 삭제
		r.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");	 
		return mv;
	}
	
	/* 서버에서 화면으로 데이터 전송 */
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public ModelAndView test1Get(Locale locale, ModelAndView mv, HttpServletRequest r) {
		String studentName = "홍길동";
		int studentAge = 18;
		/* 문제
		  	- 서버에서 보낸 데이터를 이용하여 학생 이름과 나이를 화면에 출력 되도록 test1.jsp 코드를 수정해 보세요
		*/
		mv.addObject("name", studentName);
		mv.addObject("age", studentAge);
		
		TestVo testVo = new TestVo("임꺾정", 17);
		
		/* 문제
		  	- 서버에서 보낸 testVo 데이터를 이용하여 학생 이름과 나이를 화면에 출력되도록 test1.jsp 코드를 수정해보세요.
		*/
		mv.addObject("testVo", testVo);
		
		/* 문제
		  	- 서버에서 보낸 start와 end를 이용하여 start부터 end사이의 숫자를 출력하는 코드 test1.jsp에 작성
		*/
		mv.addObject("start", 1);
		mv.addObject("end", 5);
		
		ArrayList<TestVo> list = new ArrayList<TestVo>();
		list.add(new TestVo("김철수",20));
		list.add(new TestVo("김영희",19));
		
		/* 문제
		 	- 서버에서 보낸 학생들 정보가 들어있는 list를 이용하여 학생들 이름과 나이를 출력하는 코드를 test1.jsp에 출력하는 코드 작성
		*/
		mv.addObject("list", list);
		mv.setViewName("/main/test1");	 
		return mv;
	}
	
	/* 화면에서 서버로 데이터 전송1 */
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public ModelAndView test2Get(Locale locale, ModelAndView mv, String name) {
		System.out.println(name);
		mv.setViewName("/main/test2");	 
		return mv;
	}
	/* 화면에서 서버로 데이터 전송2 */
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public ModelAndView test3Get(Locale locale, ModelAndView mv, TestVo testVo) {
		System.out.println("/test3 - 정보 : " + testVo);
		
		mv.setViewName("/main/test2");	 
		return mv;
	}
	/* 화면에서 서버로 데이터 전송3 */
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public ModelAndView test4Get(Locale locale, ModelAndView mv, String[] name) {
		for(String tmp : name) {
			System.out.println("/test4 - 정보 : " + tmp);
		}
		mv.setViewName("/main/test2");	 
		return mv;
	}
	/* 화면에서 서버로 데이터 전송4 */
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public ModelAndView test5Get(Locale locale, ModelAndView mv, String name) {
		System.out.println("/test5 - 이름 : " + name);
		String[] names = name.split(",");	// 구분자를 기준으로 나누어서 배열로 만듦
		for(String tmp : names) {
			System.out.println("이름 : " + tmp);
		}
		mv.setViewName("/main/test2");	 
		return mv;
	}
	
	
}
