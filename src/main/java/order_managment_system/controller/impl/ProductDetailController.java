package order_managment_system.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import order_managment_system.controller.IProductDetailController;
import order_managment_system.entity.Category;
import order_managment_system.entity.Product;
import order_managment_system.service.ICategoryService;
import order_managment_system.service.impl.ProductDetailService;

@CrossOrigin
@RestController
public class ProductDetailController implements IProductDetailController {

	@Autowired
	private ProductDetailService productservice;

		@Override
	public Product add(@RequestBody Product product) {

		if(product.getQuantity()>0)
			product.setStatus(true);
		else
			product.setStatus(false);
		return productservice.add(product);

		
		
	}

	@Override
	public Product update(@RequestBody Product product) {
				
		try {
			return productservice.update(product);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}

	@Override
	public String deletebyid(@RequestBody int id) {
		System.out.println("Contoller");
		 productservice.deletebyid(id);
        return "product deleted";
	}

	@Override
	public List<Product> getAllProducts() {
		System.out.println("controller ....");
		return productservice.getAllProducts();
	}

	@Override
	public Product getByName(String prodName) {
		return productservice.getByName(prodName);
	}

	@Override
	public List<Product> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

}