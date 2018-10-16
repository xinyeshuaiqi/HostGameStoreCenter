package pers.wmx.reply.web.action;

import java.util.Date;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import pers.wmx.product.domain.Product;
import pers.wmx.product.service.ProductService;
import pers.wmx.reply.domain.Reply;
import pers.wmx.reply.service.ReplyService;
import pers.wmx.user.domain.User;


public class ReplyAction extends ActionSupport implements ModelDriven<Reply> {
	private Reply reply=new Reply();
	
	public Reply getModel() {
		return reply;
	}
	
	private String pid;
	
	private ReplyService replyService;	
	private ProductService productService;	
	
	
	//----------------------------------------------

	//Ìí¼ÓÆÀÂÛ
	public String add(){
		reply.setCreateDate(new Date());
		
		System.out.println(pid);	
		int id=Integer.parseInt(pid);
		System.out.println(id);
		
		Product findProduct=productService.findById(id);
		User user = (User) ActionContext.getContext().getSession().get("user");
		/*HttpSession session = ServletActionContext.getRequest().getSession();  
		User user = (User) session.getAttribute("user");*/
		System.out.println("reply----------"+user);
		
		reply.setProduct(findProduct);
		reply.setUser(user);
			
		replyService.save(reply);
			
		return "addReply";	
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
}
