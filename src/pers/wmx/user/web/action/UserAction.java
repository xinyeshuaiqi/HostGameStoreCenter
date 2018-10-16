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
	
	//表单中输入的验证码
	private String code;  
	
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	//--------------------------------------
	
	
	/*
	 * 注册
	 * */
	public String register(){
		String checkCode = (String) ActionContext.getContext().getSession().get("checkCode");
		/*System.out.println(checkCode);
		System.out.println(code);*/
		
		//如果验证码不正确，跳回注册页面
		if(!code.equalsIgnoreCase(checkCode)){
			this.addFieldError("code", "验证码错误");
			return "fail";
		}
		//如果验证码正确
		
		User findUser=userService.findUserByName(user.getUsername());
		if(findUser!=null){
			this.addActionError("用户名已存在");
			
			return "fail";
		}
		
		user.setRole("user");
		user.setActiveCode(UUID.randomUUID().toString()); //手动设置激活码
		
		userService.register(user);
		
		return "register";
	}
	
	
	/*
	 * 激活 激活码
	 * */

	public String active(){
		System.out.println("activeCode="+user.getActiveCode());  
		userService.active(user.getActiveCode());
		
		return "active";
	}
	
	
	/*
	 * 登陆
	 * */
	public String login(){
		User findUser=userService.findUser(user.getUsername(),user.getPassword());
		
		if(findUser==null){
			this.addActionError("用户名或密码错误");
			return "login";
		}
		
		else{
			ActionContext.getContext().getSession().put("user", findUser);
			
			if(findUser.getState()==0){
				this.addActionError("用户未激活");
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
