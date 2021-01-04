package kr.green.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.UserDao;
import kr.green.test.vo.Uservo;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public String getEmail(String id) {
		Uservo user = userDao.getUser(id);
		//id와 일치하는 회원 정보가 없으면
		if(user == null) {
			return null;
		}
		//id와 일치하는 회원이 있으면
		return user.getEmail();
	}

	@Override
	public Uservo getUser(String id) {
		Uservo user = userDao.getUser(id);
		return user;
	}

	@Override
	public boolean isUser(String id, String pw) {
		Uservo user = userDao.getUser(id);
		//id와 일치하는 회원 정보가 없으면
		if(user ==null) {
			return false;
		}
		//id와 일치하는 회원 정보가 있으면 비밀번호를 비교하여 확인
		if(user.getPw().equals(pw)) {
			return true;	// 비밀번호가 같아서 회원임
		}
		return false;		// 비밀번호가 달라서 회원 아님
	}

	@Override
	public boolean signup(Uservo user) {
		
		return false;
	}
	
}
