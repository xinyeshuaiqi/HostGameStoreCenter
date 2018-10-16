package pers.wmx.order.web.action;



import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import pers.wmx.order.domain.Order;
import pers.wmx.order.service.OrderService;
import pers.wmx.orderitem.dao.OrderItemDao;
import pers.wmx.orderitem.domain.OrderItem;
import pers.wmx.orderitem.sevice.OrderItemService;
import pers.wmx.product.domain.Product;
import pers.wmx.user.domain.User;
import pers.wmx.utils.PaymentUtil;

public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	private Order order=new Order();
	
	public Order getModel() {
		return order;
	}
	
	OrderService orderService;

	
	
	OrderItemService orderItemService;
	
	//----------------------------
	
	
	
	//生成订单
	public String createOrder(){
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		order.setUser(user);
		
		order.setOrdertime(new Date());
		
		Map<Product, String> cart = (Map<Product, String>) ActionContext.getContext().getSession().get("cart");
		
		Set<OrderItem> orderItemSet=new HashSet<>();
		
		for (Product p: cart.keySet()) {
			OrderItem o=new OrderItem();
			o.setProduct(p);
			o.setOrder(order);
			o.setBuynum(Integer.parseInt(cart.get(p)));
			
			orderItemService.createOrderItem(o);
			
			orderItemSet.add(o);
		}
		
		order.setOrderItemSet(orderItemSet);
		
		orderService.create(order);
		
		ActionContext.getContext().getValueStack().push(order);
		
		return "createOrder";
	}
	
	private String yh;
	
	public void setYh(String yh) {
		this.yh = yh;
	}

	//在线支付
	public String payOnline(){
		//获取用户提交的数据
		String money=order.getMoney()+"";
		String orderid = order.getId()+"";	
		
		System.out.println("orderid："+orderid+",money:"+money);
		
		//发给第三方的信息
		String p0_Cmd="Buy";
		String p1_MerId="10001126856";
		String p2_Order=orderid;
		String p3_Amt=money;
		String p4_Cur="CNY";		
		String p5_Pid="unknown";		
		String p6_Pcat="unknown";
		String p7_Pdesc="unknown";		
		String p8_Url="http://localhost:8080/HostGameStoreCenter/CallBackAction_isPayed";		
		String p9_SAF="1";
		String pa_MP="unknown";
		String pd_FrpId=yh;	
		String pr_NeedResponse="1";   //点对点发送信息
		String hmac=PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");
		
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("p0_Cmd",p0_Cmd );
		session.put("p1_MerId",p1_MerId );
		session.put("p2_Order", p2_Order);
		session.put("p3_Amt", p3_Amt );
		session.put("p4_Cur",p4_Cur);
		session.put("p5_Pid",p5_Pid);
		session.put("p6_Pcat",p6_Pcat);
		session.put("p7_Pdesc",p7_Pdesc);
		session.put("p8_Url",p8_Url );
		session.put("pa_MP",pa_MP );
		session.put("pr_NeedResponse",pr_NeedResponse );
		session.put("hmac",hmac);
		session.put("p9_SAF",p9_SAF);
		session.put("pd_FrpId", pd_FrpId);
		
		
		return "payOnline";
	}
	
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	

}
