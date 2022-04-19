package order_managment_system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import order_managment_system.dao.ICategoryDao;
import order_managment_system.entity.Category;
import order_managment_system.service.ICategoryService;

@Service
public class CategoryService  implements ICategoryService{

	@Autowired
	private ICategoryDao categoryDao; 
	
	@Override 
	 public String add(Category category) {
		categoryDao.save(category); 
		return "Category added";
	}
	
	
	@Override
	public Category update(Category category)
	{
	return categoryDao.save(category);
	}

	
	@Override
	public void deletebyid(int id)
	{
	 categoryDao.deleteById(id);
	}


	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		
		return (List<Category>) categoryDao.findAll();
	}


	@Override
	public Category findById(Integer id) {
		Optional<Category> category= categoryDao.findById(id);
		if(category.isPresent()) {
			return category.get();
			}
		else{
			throw new RuntimeException("Invalid category");
		}
	}

	
	}


