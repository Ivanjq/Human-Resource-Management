package com.hrm.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.domain.User;

/*拦截器必须实现HandlerInterceptor*/
public class LoginInterceptor implements HandlerInterceptor {
	//不拦截"/index" 和 "/login" 请求
	//private static final String[] IGNORE_URI={"/index","/login"};
	private static final String[] IGNORE_URI={"/login"};
	
	/*该方法将在整个请求完成后执行，主要作用就是用于清理资源*/
	/*该方法也只能在当前Interceptor的preHandle方法的返回值为true时才会执行*/
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceptor afterCompletion -->");
	}

	/*该方法将在Controller的方法调用之后执行，方法可以对ModelAndView进行操作*/
	/*该方法也只能在当前Interceptor的preHandle方法的返回值为true时才会执行*/
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceptor postHandle -->");
	}

	/*preHandle方法是进行处理器拦截用的，该方法将在Controller的方法调用之后执行*/
	/*该方法的返回值为true时才会继续往下执行，该方法的返回值为false时整个会停止执行*/
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceptor preHandle -->");
		//flag变量用于判断用户是否登录，默认为false
		boolean flag=false;
		//获取请求的路径进行判断
		String servletPath=request.getServletPath();
		
		//判断请求是否需要拦截
		for(String s:IGNORE_URI){
			if(servletPath.contains(s)){
				flag=true;
				break;
			}
		}
		/*或者<mvc:exclude-mapping path="/login"/>*/
		
		//拦截请求
		if(!flag){
			//获取session中的用户
			User user=(User)request.getSession().getAttribute("user");
			//判断用户是否已经登录
			if(user==null){
				//如果用户没有登录，则设置提示信息，跳转到登录页面
				System.out.println("LoginInterceptor 拦截请求");
				request.setAttribute("msg", "请先登录再访问网站");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}else{
				//如果用户已经登录，则通过验证通过，放行
				System.out.println("LoginInterceptor 放行请求");
				flag=true;
			}
		}
		return flag;
	}

}
