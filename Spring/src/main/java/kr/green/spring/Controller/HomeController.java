package kr.green.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.UserService;
import kr.green.spring.vo.TestVo;
import kr.green.spring.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	/* 홈 */
	@RequestMapping(value = "/", method = RequestMethod.GET)		//url이 localhost:8080/spring 가 기본 입력 되어있음
	public ModelAndView home(Locale locale, ModelAndView mv) {
		
		mv.setViewName("/main/home");	// 어떠한 jsp와 연결할 것인지 물어보는 메소드
		return mv;
	}
	
	/* 로그인 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)	//url이 localhost:8080/spring 가 기본 입력 되어있음
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
		UserVo isUser = userService.isUser(username, password);
		
		mv.addObject("user", isUser);	// 인터셉터가 가로챌수있게 컨트롤러에서 화면으로 데이터를 전송해준다.
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
	public ModelAndView signupPost(Locale locale, ModelAndView mv, UserVo user) {
		
		System.out.println(user);
		
		boolean signup = userService.signup(user);
		System.out.println(signup);
		if(signup) {
			//mv.setViewName("/main/home");	 localhost:8080/spring/signup	- url만 그대로고 화면만 home화면 보여주는거
			mv.setViewName("redirect:/");	// localhost:8080/test/			- url이 home으로 바뀜
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	
	/* 로그아웃 */
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest request) {
		// 세션에 저장된 유저 정보를 삭제
		request.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");	 
		return mv;
	}
	
	@RequestMapping(value = "/user/list2", method = RequestMethod.GET)
	public ModelAndView userListGet(ModelAndView mv) {
		ArrayList<UserVo> list = new ArrayList<UserVo>();
		//모든 회원 정보를 가져오는 코드
		list = userService.getAllUser();
		mv.addObject("list",list);
		mv.setViewName("/board/list2");
		return mv;
	}
	/* ajax 예제1 */
	@RequestMapping(value = "/ajax1", method = RequestMethod.POST)		//url이 localhost:8080/spring 가 기본 입력 되어있음
	@ResponseBody
	public String ajax1Post(TestVo testVo) {
		System.out.println("ajax 테스트 성공!");
		System.out.println(testVo);
		return testVo.toString();
	}
	
	@RequestMapping(value = "/dup", method = RequestMethod.POST)		//url이 localhost:8080/spring 가 기본 입력 되어있음
	@ResponseBody
	public String dupPost(String id) {
		UserVo user = userService.getUser(id);
		if(user == null)
			return "not user";
		return "user";
	}
	
	/* ajax 예제2 */
	@RequestMapping(value = "/ajax2", method = RequestMethod.POST)		//url이 localhost:8080/spring 가 기본 입력 되어있음
	@ResponseBody
	// 리턴타입을 Object로 하면 아무거다 다 리턴 할수있다.
	public Object ajax2Post(@RequestBody TestVo testVo) {	// json형태로 받으려면 @RequestBody 추가해야됨
		HashMap<String, Object> map = new HashMap<String,Object>(); // key에 해당하는 이름이 중복되지않게 데이터를 보낼수있다.
		ArrayList<UserVo> list = userService.getAllUser();
		// map에 데이터 여러개 추가해서 한꺼번에 보낼 수 있다.
		map.put("list", list);
		map.put("testVo", testVo);
		return map;	// json 사용하려면 map을 이용해서 서버에서 화면이로 데이터를 보내야한다.
	}
	
	/* list2 내용 수정 */
	@RequestMapping(value = "/author/modify", method = RequestMethod.POST)		//url이 localhost:8080/spring 가 기본 입력 되어있음
	@ResponseBody
	// 리턴타입을 Object로 하면 아무거다 다 리턴 할수있다.
	public Object authorModifyPost(@RequestBody UserVo userVo) {	
		userService.updateAuthor(userVo);
		// json형태로 보내주는거는 map으로 보내주는거다.
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		return map;
	}

}
