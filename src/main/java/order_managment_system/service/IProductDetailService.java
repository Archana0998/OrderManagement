package order_managment_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import order_managment_system.entity.Product;


public interface IProductDetailService {

	public Product update(Product product) throws Exception;

	void deletebyid(int id);

	Product add(Product product);
	
	public List<Product> getAllProducts();

	public Product getByName(String prodName);

	public Product getById(int id);

	public void save(Product product);

}
