package kr.green.test.service;

import kr.green.test.vo.Uservo;

public interface UserService {
	
	String getEmail(String id);
	Uservo getUser(String id);
	boolean isUser(String id, String pw);
	boolean signup(Uservo user);
	
}
