package kr.green.spring.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.spring.vo.UserVo;

public interface UserService {
	
	String getEmail(String id);
	UserVo getUser(String id);
	UserVo isUser(String id, String pw);
	boolean signup(UserVo user);
	UserVo getUser(HttpServletRequest request); // HttpServletRequest가 주어지면 회원 정보를 가져오는 메소드 ( 메소드 오버로딩 )
	ArrayList<UserVo> getAllUser();
	void updateAuthor(UserVo userVo);
	
}
