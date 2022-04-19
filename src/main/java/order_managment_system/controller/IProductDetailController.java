package order_managment_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import order_managment_system.entity.Product;

@RequestMapping({ "/ProductDetail" })
public interface IProductDetailController {

	@PostMapping("/add")
	public Product add(Product product);

//	@PutMapping("/update/{id}")
//	public Product update(Product product@PathVariable int id);

	@DeleteMapping("/delete/{id}")
	public String deletebyid(@PathVariable int id);

	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts();

	@GetMapping("/getByName")
	public Product getByName(@RequestParam(name = "prodName")String prodName);
	
	@PostMapping("/Count")
	public List<Product>getAllList();

	
	@PutMapping("/update")
	Product update(Product product);
	
	
	

}