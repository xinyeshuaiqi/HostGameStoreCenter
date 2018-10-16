package pers.wmx.web.result;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

import cn.dsna.util.images.ValidateCode;

/*���ܣ�������֤��
 * 
 * �Զ���������
 * 1����дһ����ͨ��̳�StrutsResultSupport
 * 2����дdoExecute
 * */
public class MyResult extends StrutsResultSupport {
	//ͨ�������ļ�����������ͼƬ��С
	private int width;
	private int height;
	
	@Override
	protected void doExecute(String arg0, ActionInvocation arg1) throws Exception {
		/*��������֤��������
		 * 1�����
		 * 2���߶�
		 * 3�����ָ�ʽ
		 * 4������������
		 * 
		 * */
		
		ValidateCode vc=new ValidateCode(width,height,4,10);
		
		String checkCode=vc.getCode();
		HttpSession session = ServletActionContext.getRequest().getSession(); 
		session.setAttribute("checkCode", checkCode);  
		
		//��ȡ��Ӧ����
		HttpServletResponse response=ServletActionContext.getResponse(); 

		//����������
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
