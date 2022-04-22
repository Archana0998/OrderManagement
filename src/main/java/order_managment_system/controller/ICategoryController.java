package order_managment_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import order_managment_system.entity.Category;



@RequestMapping("/category")
public interface ICategoryController 
{
		
			@PostMapping("/add")
			public String add(Category category);
		
			@PutMapping("/update")
			public Category update( Category category);
			
			@DeleteMapping("/delete/{id}")
			public String deletebyid(@PathVariable int id);
			
			@GetMapping("/getAll")
			public List<Category> getAllCategories();
			
			
}
