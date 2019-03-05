package com.hrm.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.domain.User;

/*����������ʵ��HandlerInterceptor*/
public class LoginInterceptor implements HandlerInterceptor {
	//������"/index" �� "/login" ����
	//private static final String[] IGNORE_URI={"/index","/login"};
	private static final String[] IGNORE_URI={"/login"};
	
	/*�÷�����������������ɺ�ִ�У���Ҫ���þ�������������Դ*/
	/*�÷���Ҳֻ���ڵ�ǰInterceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ��*/
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceptor afterCompletion -->");
	}

	/*�÷�������Controller�ķ�������֮��ִ�У��������Զ�ModelAndView���в���*/
	/*�÷���Ҳֻ���ڵ�ǰInterceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ��*/
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceptor postHandle -->");
	}

	/*preHandle�����ǽ��д����������õģ��÷�������Controller�ķ�������֮��ִ��*/
	/*�÷����ķ���ֵΪtrueʱ�Ż��������ִ�У��÷����ķ���ֵΪfalseʱ������ִֹͣ��*/
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceptor preHandle -->");
		//flag���������ж��û��Ƿ��¼��Ĭ��Ϊfalse
		boolean flag=false;
		//��ȡ�����·�������ж�
		String servletPath=request.getServletPath();
		
		//�ж������Ƿ���Ҫ����
		for(String s:IGNORE_URI){
			if(servletPath.contains(s)){
				flag=true;
				break;
			}
		}
		/*����<mvc:exclude-mapping path="/login"/>*/
		
		//��������
		if(!flag){
			//��ȡsession�е��û�
			User user=(User)request.getSession().getAttribute("user");
			//�ж��û��Ƿ��Ѿ���¼
			if(user==null){
				//����û�û�е�¼����������ʾ��Ϣ����ת����¼ҳ��
				System.out.println("LoginInterceptor ��������");
				request.setAttribute("msg", "���ȵ�¼�ٷ�����վ");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}else{
				//����û��Ѿ���¼����ͨ����֤ͨ��������
				System.out.println("LoginInterceptor ��������");
				flag=true;
			}
		}
		return flag;
	}

}
