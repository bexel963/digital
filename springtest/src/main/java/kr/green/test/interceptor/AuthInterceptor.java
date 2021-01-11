package kr.green.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	// preHandle 어떤 url로 가기전에 만나서 수행되는 메소드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		HttpSession session = request.getSession();		// 현재 세션 정보 가져옴
		Object user = session.getAttribute("user");		// LoginInterceptor에서 user정보 가져옴
		if(user == null) {								// 로그인이 안되면
			response.sendRedirect(request.getContextPath()+"/board/list");	// 가려던 url 가지말고 /board/list로 이동
			return false;
		}
		return true;	// 가려던 url로 가세요
	}
}
