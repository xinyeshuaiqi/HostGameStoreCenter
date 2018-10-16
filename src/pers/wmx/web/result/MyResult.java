package pers.wmx.web.result;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

import cn.dsna.util.images.ValidateCode;

/*功能：生成验证码
 * 
 * 自定义结果类型
 * 1，编写一个普通类继承StrutsResultSupport
 * 2，重写doExecute
 * */
public class MyResult extends StrutsResultSupport {
	//通过配置文件，调整生成图片大小
	private int width;
	private int height;
	
	@Override
	protected void doExecute(String arg0, ActionInvocation arg1) throws Exception {
		/*第三方验证码参数详解
		 * 1，宽度
		 * 2，高度
		 * 3，数字格式
		 * 4，干扰线条数
		 * 
		 * */
		
		ValidateCode vc=new ValidateCode(width,height,4,10);
		
		String checkCode=vc.getCode();
		HttpSession session = ServletActionContext.getRequest().getSession(); 
		session.setAttribute("checkCode", checkCode);  
		
		//获取响应对象
		HttpServletResponse response=ServletActionContext.getResponse(); 

		//输出到浏览器
		vc.write(response.getOutputStream());
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
