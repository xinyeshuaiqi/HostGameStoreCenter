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
			//�����Ѻ���Ϣ
			Object obj=invocation.getAction();
			//����ʱ�Ƿ���ActionSupport
			
			if(obj instanceof ActionSupport){
				ActionSupport NowAction=(ActionSupport)obj;
				NowAction.addFieldError("", "���¼");
			}
			
			//���������ֱ��return �����actionҲִ�в�����
			return "login";
		}
		
		return invocation.invoke();
	}

}
