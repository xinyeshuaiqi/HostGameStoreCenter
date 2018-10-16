package pers.wmx.product.web.action;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import pers.wmx.page.domain.PageBean;
import pers.wmx.product.domain.Product;
import pers.wmx.product.service.ProductService;

public class ProductAction extends ActionSupport implements ModelDriven<Product> {
	private Product product=new Product();
	
	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public Product getModel() {
		
		return product;
	}
	
	private ProductService productService;


	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	private File photo;
	
	//Struts2在文件上传提供的属性
	private String photoFileName;     //上传的文件名。上传字段名称+FileName
	private String photoContentType;  //上传的文件的MIME类型。上传字段名称+ContentType
	
	
	public void setPhoto(File photo) {
		this.photo = photo;
	}


	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}


	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
	//分页查询
	private int currentPage=1;
	private int pageSize=4;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	//-------------------------------------------------------------
	
	//-----------------------------管理员操作-------------------------
	
	//显示商品
	public String findAll(){
		List<Product> allProduct= productService.findAll();
		ActionContext.getContext().put("allProduct", allProduct);
		
		return "findAll";
	}
	
	
	
	
	//添加商品
	public String add(){
		ServletContext application=ServletActionContext.getServletContext();
		
		//根据一个虚拟目录返回一个真实目录
		String realPath = application.getRealPath("/productImg");
		
		File file=new File(realPath);
		if(!file.exists()){
			file.mkdirs();
		}
		
		photoFileName=UUID.randomUUID()+photoFileName;
		
		photo.renameTo(new File(file,photoFileName));
		
		product.setImg_url(photoFileName);
		
		productService.add(product);
		
		
		return "add";
	}
	
	//编辑前
	public String editUI(){
		//页面传来id
		Product findProduct=productService.findById(product.getId());
		
		//来压栈
		ActionContext.getContext().getValueStack().push(findProduct);
		
				
		return "editUI";
	}
	
	//编辑
	public String edit(){
		ServletContext application=ServletActionContext.getServletContext();
		
		//根据一个虚拟目录返回一个真实目录
		String realPath = application.getRealPath("/productImg");
		
		File file=new File(realPath);
		if(!file.exists()){
			file.mkdirs();
		}
		
		photoFileName=UUID.randomUUID()+photoFileName;
		
		photo.renameTo(new File(file,photoFileName));
		
		product.setImg_url(photoFileName);
		
		productService.edit(product);
				
		return "edit";
	}
	
	//删除
	public String delete(){
		productService.delete(product);
		
		return "delete";
	}
	
	
	//-----------------前台-用户浏览-----------------------------
	
	/*
	 * 条件+分页查询
	 * */
	public String findAllByCondition(){
		
		System.out.println("当前页："+currentPage);
		
		PageBean<Product> pageBean =productService.findAll(product, currentPage, pageSize);
		
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "findAllByCondition";
	}

	/*
	 * 通过id查询
	 * 再把数据显示到商品详情页面
	 * */
	public String findById(){
		System.out.println(product.getId());
		
		Product findProduct= productService.findById(product.getId());
		
		ActionContext.getContext().getValueStack().push(findProduct);
		
		return "findById";
	}
	
	
	/*
	 * 购买商品
	 * 把商品添加到购物车(session)
	 * */
	
	public String addCart(){
		System.out.println(product.getId());
		
		Product findProduct=productService.findById(product.getId());
		
		Map<Product, String> cart = (Map<Product, String>) ActionContext.getContext().getSession().get("cart");
		
		int flag=0;  //表示这个商品还没有买过
		
		int num=1;
		if(cart==null){
			cart=new HashMap<Product,String>();
			//把图书放入购物车
			cart.put(findProduct,num+"");
			flag=1;        //购物车为空
		}else{		
			for (Map.Entry<Product, String> entry : cart.entrySet()) {  
				
			    Product key = entry.getKey();
			    String value = entry.getValue();
			    
			    if(key.getId().equals(findProduct.getId())){
			    	value=Integer.parseInt(value)+1+"";
			    	entry.setValue(value);
			    	flag=2;
			    	//表示这个商品已经被买过，又买了一次
			
			    }
			    
			    
			}
			
			if(flag==0){  //表示购物车不为空且第一次买
				cart.put(findProduct,num+"");
			}
		}
		
		
		  
		ActionContext.getContext().getSession().put("cart", cart);
		
		return "addCart";
	}
	
	private String  num;  //购书数量
	
	
	public void setNum(String num) {
		this.num = num;
	}


	public String changeNum(){
		System.out.println(product.getId());
		
		Product findProduct=productService.findById(product.getId());
		Map<Product, String> cart = (Map<Product, String>) ActionContext.getContext().getSession().get("cart");
		
		//Iterator<Product> iterator = cart.keySet().iterator(); 
		
		/*if("0".equals(num)){
			while(iterator.hasNext()){
				Product key=iterator.next();
				if(key.getId().equals(findProduct.getId())){
					cart.remove(key);
				}
			}
		}else{
			while(iterator.hasNext()){
				Product key=iterator.next();
				if(key.getId().equals(findProduct.getId())){
					cart.put(key, num);
				}
			}
		}*/
		
		if("0".equals(num)){
			cart.remove(findProduct);
		}
		
		if(cart.containsKey(findProduct)){  //HashCode根据id比较
			cart.put(findProduct,num);
		}
		
		ActionContext.getContext().getSession().put("cart", cart);
		
		return "changeNum";
	}
	
}
