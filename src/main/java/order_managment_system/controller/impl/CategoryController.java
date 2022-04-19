package order_managment_system.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import order_managment_system.controller.ICategoryController;
import order_managment_system.entity.Category;
import order_managment_system.service.ICategoryService;

@CrossOrigin
@RestController
public class CategoryController implements ICategoryController{
	
	@Autowired
	private ICategoryService categoryService;
	
	
	
	@Override
	public String add(@RequestBody Category category) {
		System.out.println("addCategory ... ");
		boolean bool = true;
		List<Category> allCategories = categoryService.getAllCategories();
		for(Category cat : allCategories)
		{
			if(cat.getCatName().equals(category.getCatName()))
			{
				bool = false;
				break;
			}
		}
		if(bool==true)
		{
			return categoryService.add(category);
		}
		else
		{
			 System.out.println("Category is already present !!");
			 return "Category is already present";
		}
	}
 
	@Override
	public Category update(@RequestBody Category category)
	{
		return categoryService.update(category);
		
	}

	@Override
  	public String deletebyid(@RequestBody  int id) {
		 categoryService.deletebyid(id);
		 return "category deleted";
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryService.getAllCategories();
	}

	
}	


