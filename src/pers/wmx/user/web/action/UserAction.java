package pers.wmx.user.web.action;


import java.util.UUID;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import pers.wmx.user.domain.User;
import pers.wmx.user.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	User user=new User();
	
	public User getModel() {
		
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//�����������֤��
	private String code;  
	
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	//--------------------------------------
	
	
	/*
	 * ע��
	 * */
	public String register(){
		String checkCode = (String) ActionContext.getContext().getSession().get("checkCode");
		/*System.out.println(checkCode);
		System.out.println(code);*/
		
		//�����֤�벻��ȷ������ע��ҳ��
		if(!code.equalsIgnoreCase(checkCode)){
			this.addFieldError("code", "��֤�����");
			return "fail";
		}
		//�����֤����ȷ
		
		User findUser=userService.findUserByName(user.getUsername());
		if(findUser!=null){
			this.addActionError("�û����Ѵ���");
			
			return "fail";
		}
		
		user.setRole("user");
		user.setActiveCode(UUID.randomUUID().toString()); //�ֶ����ü�����
		
		userService.register(user);
		
		return "register";
	}
	
	
	/*
	 * ���� ������
	 * */

	public String active(){
		System.out.println("activeCode="+user.getActiveCode());  
		userService.active(user.getActiveCode());
		
		return "active";
	}
	
	
	/*
	 * ��½
	 * */
	public String login(){
		User findUser=userService.findUser(user.getUsername(),user.getPassword());
		
		if(findUser==null){
			this.addActionError("�û������������");
			return "login";
		}
		
		else{
			ActionContext.getContext().getSession().put("user", findUser);
			
			if(findUser.getState()==0){
				this.addActionError("�û�δ����");
				return "login";
			}
			
			if("admin".equals(findUser.getRole())){
				return "adminLogin";
			}else {
				return "userLogin";
			}
		}
		
		
	}
	

}
