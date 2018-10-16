package pers.wmx.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;



public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		
		Object user = ActionContext.getContext().getSession().get("user");
		
		if(user==null){
			//整点友好信息
			Object obj=invocation.getAction();
			//运行时是否是ActionSupport
			
			if(obj instanceof ActionSupport){
				ActionSupport NowAction=(ActionSupport)obj;
				NowAction.addFieldError("", "请登录");
			}
			
			//如果拦截器直接return 后面的action也执行不到了
			return "login";
		}
		
		return invocation.invoke();
	}

}
