package kr.green.spring.service;

import java.util.ArrayList;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	@Autowired
	private JavaMailSender mailSender;
	
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

	@Override
	public ArrayList<UserVo> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void updateAuthor(UserVo userVo) {
		userDao.updateAuthor(userVo);
	}

	@Override
	public void updateUser(UserVo user) {
		if(user == null) {
			return;
		}
		String encodePw = passwordEncoder.encode(user.getPw());
		user.setPw(encodePw);
		userDao.updateUser(user);
	}

	@Override
	public void sendMail(String title, String content, String email) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom("test@naver.com");  // 딱히 의미는 없지만 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(email);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(content);  // 메일 내용

	        mailSender.send(message);
	    } catch(Exception e){
	        System.out.println(e);
	    }
	}

	@Override
	public String getNewPassword(int size) {
		/* 
		 * 비밀번호는 0~9숫자(10), a~z소문자(26), A~Z대문자(26) 
		 * 랜덤으로 0~61을 생성 => 62가지
		 * 랜덤 숫자가 0~9 => 숫자 0~9
		 * 랜덤 숫자가 10~35 => a~z
		 * 랜덤 숫자가 36~61 => A~Z
		 * 10 => 'a' + 10 - 10
		 * 11 => 'a' + 11 - 10
		 * 37 => 'A' + 37 - 36
		 * 38 => 'A' + 38 - 36 
		 */
		String pw = "";
		for(int i=0 ; i<size ; i++) {
			int r =(int)(Math.random() * 62);	// 0이상 62미만의 숫자
			if(r <= 9) {
				pw += (char)('0' + r - 0);
			}else if( r <= 35) {
				pw += (char)('a' + r - 10);
			}else {
				pw += (char)('A' + r - 36);
			}
		}
		return pw;
	}
	
}

















