package kr.green.test.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.test.vo.Uservo;

public interface UserService {
	
	String getEmail(String id);
	
	Uservo getUser(String id);
	
	Uservo isUser(String id, String pw);
	
	boolean signup(Uservo user);
	
	Uservo getUser(HttpServletRequest request);
}
