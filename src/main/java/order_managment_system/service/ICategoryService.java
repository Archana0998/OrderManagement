package order_managment_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import order_managment_system.entity.Category;


public interface ICategoryService {

	public Category update(Category category);

	public String add(Category category);

	public void deletebyid(int id);
	
	public List<Category> getAllCategories();
	

	Category findById(Integer id);
}
