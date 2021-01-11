package kr.green.test.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.test.dao.UserDao;
import kr.green.test.vo.Uservo;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

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
	public Uservo isUser(String id, String pw) {
		Uservo user = userDao.getUser(id);
		//id와 일치하는 회원 정보가 없으면
		if(user ==null) {
			return null;
		}
		//id와 일치하는 회원 정보가 있으면 비밀번호를 비교하여 확인
		if(passwordEncoder.matches(pw, user.getPw())) {
			return user;	// 비밀번호가 같아서 회원임
		}
		return null;		// 비밀번호가 달라서 회원 아님
	}

	@Override
	public boolean signup(Uservo user) {
		//user = userDao.getUser(id);
		Uservo tmp = userDao.getUser(user.getId());
		if(tmp != null) {					// 이미 가입된 회원이면 회원가입 진행 불가
			return false;
		}else {								// 가입된 회원이 아니면 회원가입을 진행
			String pw = user.getPw();
			String encodePw = passwordEncoder.encode(pw);	
			user.setPw(encodePw);
			userDao.insertUser(user);
			return true;
		}
	
	}

	@Override
	public Uservo getUser(HttpServletRequest request) {
		Uservo user = (Uservo)request.getSession().getAttribute("user");	// 세션정보를 가져오고 가져온 정보중에 user라는 이름으로 등록된 속성이 있으면 가져오고 Uservo로 형변환
		return user;
	}
	
}
