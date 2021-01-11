package kr.green.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.UserDao;
import kr.green.spring.vo.UserVo;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public String getEmail(String id) {
		UserVo user = userDao.getUser(id);
		//id와 일치하는 회원 정보가 없으면
		if(user == null) {
			return null;
		}
		//id와 일치하는 회원이 있으면
		return user.getEmail();
	}

	@Override
	public UserVo getUser(String id) {
		UserVo user = userDao.getUser(id);
		return user;
	}

	@Override
	public UserVo isUser(String id, String pw) {
		UserVo user = userDao.getUser(id);
		//id와 일치하는 회원 정보가 없으면
		if(user == null) {
			return null;
		}
		//id와 일치하는 회원 정보가 있으면 비밀번호를 비교하여 확인
		if(passwordEncoder.matches(pw, user.getPw())) {		// matches는 입력한 비밀번호와 암호화된 비밀번호가 일치하는지 확인해주는 메소드
			return user;	// 비밀번호가 같아서 회원임
		}
		return null;		// 비밀번호가 달라서 회원 아님
	}

	@Override
	public boolean signup(UserVo user) {
		//user = userDao.getUser(id);
		UserVo tmp = userDao.getUser(user.getId());
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
	public UserVo getUser(HttpServletRequest request) {
		return (UserVo)request.getSession().getAttribute("user");		// 세션에서 user정보 가져오는 코드
	}
	
}
