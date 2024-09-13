package order_managment_system.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import order_managment_system.dao.ICategoryDao;
import order_managment_system.dao.IProductDetailDao;
import order_managment_system.entity.Category;
import order_managment_system.entity.Product;
import order_managment_system.service.ICategoryService;
import order_managment_system.service.IProductDetailService;

@ComponentScan
@Service
public class ProductDetailService implements IProductDetailService {


	@Autowired
	private IProductDetailDao productDetailDao;

	
	@Autowired
	private ICategoryService categoryService;

	
	@Override
	@Transactional
	public Product add(Product product) {
		product.setCategory(categoryService.findById(product.getCategory().getId()));
		return productDetailDao.save(product);}
	

	@Override
	public void deletebyid(int id) {
		System.out.println("Service");
		 productDetailDao.deleteById(id);
		 
	}

	@Override
	public List<Product> getAllProducts() {
		System.out.println("service...........");
		return (List<Product>) productDetailDao.findAll();
	}

	@Override
	public Product getByName(String prodName) {
				
		return productDetailDao.findByProductName(prodName);
	}

	@Override
	public Product getById(int id) {
		return productDetailDao.getById(id);
	}

	
	@Override
	public void save(Product product) {
				
	}


	@Override
	public Product update(Product product) throws Exception {
		if(product.getQuantity()==0)
		{
			product.setStatus("Not Available");
		}
		else
		{
			product.setStatus("Available");
		}
		return productDetailDao.save(product);
	}


	

}
