package pers.johngao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;




public class Interceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		User u=(User) request.getSession().getAttribute("user");
//		if(u==null) {
//			response.sendRedirect("../index.html");
//			return false;
//		}
		return true;
	}
}
