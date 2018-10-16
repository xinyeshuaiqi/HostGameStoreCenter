package pers.wmx.web.action;



import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import pers.wmx.order.service.OrderService;
import pers.wmx.utils.PaymentUtil;

public class CallBackAction extends ActionSupport {
	// 获得回调所有数据    
	//get方式返回的
	private String p1_MerId ;
	private String r0_Cmd ;
	private String r1_Code ;
	private String r2_TrxId ;
	private String r3_Amt ;
	private String r4_Cur ;
	private String r5_Pid ;
	private String r6_Order ;
	private String r7_Uid ;
	private String r8_MP ;
	private String r9_BType ;
	private String rb_BankId ;
	private String ro_BankOrderId ;
	private String rp_PayDate ;
	private String rq_CardNo ;
	private String ru_Trxtime ;
	// 身份校验 --- 判断是不是支付公司通知你
	private String hmac ;
	private String keyValue ="69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
	
	private OrderService orderService;
	
	public String isPayed() throws Exception{
		// 自己对上面数据进行加密 --- 比较支付公司发过来hamc
		boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
				r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
				r8_MP, r9_BType, keyValue);
		
		if (isValid) {
			// 响应数据有效
			if (r9_BType.equals("1")) {
				
				orderService.modifyOrderState(r6_Order);
				
			} else if (r9_BType.equals("2")) {
				// 服务器点对点 --- 支付公司通知你
				System.out.println("付款成功！");  
				// 修改订单状态 为已付款
				// 回复支付公司
				HttpServletResponse response = ServletActionContext.getResponse();
				
				response.getWriter().print("success");   //给第三方看
			}
			
			return "isPayed";
		} else {
			// 数据无效
			System.out.println("数据被篡改！");
			
			return "notPayed";
		}
			
	}

	public void setP1_MerId(String p1_MerId) {
		this.p1_MerId = p1_MerId;
	}
	public void setR0_Cmd(String r0_Cmd) {
		this.r0_Cmd = r0_Cmd;
	}
	public void setR1_Code(String r1_Code) {
		this.r1_Code = r1_Code;
	}
	public void setR2_TrxId(String r2_TrxId) {
		this.r2_TrxId = r2_TrxId;
	}
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}
	public void setR4_Cur(String r4_Cur) {
		this.r4_Cur = r4_Cur;
	}
	public void setR5_Pid(String r5_Pid) {
		this.r5_Pid = r5_Pid;
	}
	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}
	public void setR7_Uid(String r7_Uid) {
		this.r7_Uid = r7_Uid;
	}
	public void setR8_MP(String r8_MP) {
		this.r8_MP = r8_MP;
	}
	public void setR9_BType(String r9_BType) {
		this.r9_BType = r9_BType;
	}
	public void setRb_BankId(String rb_BankId) {
		this.rb_BankId = rb_BankId;
	}
	public void setRo_BankOrderId(String ro_BankOrderId) {
		this.ro_BankOrderId = ro_BankOrderId;
	}
	public void setRp_PayDate(String rp_PayDate) {
		this.rp_PayDate = rp_PayDate;
	}
	public void setRq_CardNo(String rq_CardNo) {
		this.rq_CardNo = rq_CardNo;
	}
	public void setRu_Trxtime(String ru_Trxtime) {
		this.ru_Trxtime = ru_Trxtime;
	}
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	
	
	
	
	
}
