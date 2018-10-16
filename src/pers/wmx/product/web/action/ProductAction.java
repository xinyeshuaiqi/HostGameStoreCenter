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
	
	//Struts2���ļ��ϴ��ṩ������
	private String photoFileName;     //�ϴ����ļ������ϴ��ֶ�����+FileName
	private String photoContentType;  //�ϴ����ļ���MIME���͡��ϴ��ֶ�����+ContentType
	
	
	public void setPhoto(File photo) {
		this.photo = photo;
	}


	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}


	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
	//��ҳ��ѯ
	private int currentPage=1;
	private int pageSize=4;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	//-------------------------------------------------------------
	
	//-----------------------------����Ա����-------------------------
	
	//��ʾ��Ʒ
	public String findAll(){
		List<Product> allProduct= productService.findAll();
		ActionContext.getContext().put("allProduct", allProduct);
		
		return "findAll";
	}
	
	
	
	
	//�����Ʒ
	public String add(){
		ServletContext application=ServletActionContext.getServletContext();
		
		//����һ������Ŀ¼����һ����ʵĿ¼
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
	
	//�༭ǰ
	public String editUI(){
		//ҳ�洫��id
		Product findProduct=productService.findById(product.getId());
		
		//��ѹջ
		ActionContext.getContext().getValueStack().push(findProduct);
		
				
		return "editUI";
	}
	
	//�༭
	public String edit(){
		ServletContext application=ServletActionContext.getServletContext();
		
		//����һ������Ŀ¼����һ����ʵĿ¼
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
	
	//ɾ��
	public String delete(){
		productService.delete(product);
		
		return "delete";
	}
	
	
	//-----------------ǰ̨-�û����-----------------------------
	
	/*
	 * ����+��ҳ��ѯ
	 * */
	public String findAllByCondition(){
		
		System.out.println("��ǰҳ��"+currentPage);
		
		PageBean<Product> pageBean =productService.findAll(product, currentPage, pageSize);
		
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "findAllByCondition";
	}

	/*
	 * ͨ��id��ѯ
	 * �ٰ�������ʾ����Ʒ����ҳ��
	 * */
	public String findById(){
		System.out.println(product.getId());
		
		Product findProduct= productService.findById(product.getId());
		
		ActionContext.getContext().getValueStack().push(findProduct);
		
		return "findById";
	}
	
	
	/*
	 * ������Ʒ
	 * ����Ʒ��ӵ����ﳵ(session)
	 * */
	
	public String addCart(){
		System.out.println(product.getId());
		
		Product findProduct=productService.findById(product.getId());
		
		Map<Product, String> cart = (Map<Product, String>) ActionContext.getContext().getSession().get("cart");
		
		int flag=0;  //��ʾ�����Ʒ��û�����
		
		int num=1;
		if(cart==null){
			cart=new HashMap<Product,String>();
			//��ͼ����빺�ﳵ
			cart.put(findProduct,num+"");
			flag=1;        //���ﳵΪ��
		}else{		
			for (Map.Entry<Product, String> entry : cart.entrySet()) {  
				
			    Product key = entry.getKey();
			    String value = entry.getValue();
			    
			    if(key.getId().equals(findProduct.getId())){
			    	value=Integer.parseInt(value)+1+"";
			    	entry.setValue(value);
			    	flag=2;
			    	//��ʾ�����Ʒ�Ѿ��������������һ��
			
			    }
			    
			    
			}
			
			if(flag==0){  //��ʾ���ﳵ��Ϊ���ҵ�һ����
				cart.put(findProduct,num+"");
			}
		}
		
		
		  
		ActionContext.getContext().getSession().put("cart", cart);
		
		return "addCart";
	}
	
	private String  num;  //��������
	
	
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
		
		if(cart.containsKey(findProduct)){  //HashCode����id�Ƚ�
			cart.put(findProduct,num);
		}
		
		ActionContext.getContext().getSession().put("cart", cart);
		
		return "changeNum";
	}
	
}
