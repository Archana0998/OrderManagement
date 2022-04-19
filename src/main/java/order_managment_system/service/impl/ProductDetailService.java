package order_managment_system.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	private ICategoryDao categoryDao;


	@Autowired
	private ICategoryService categoryService;

	
	@Override
	@Transactional
	public Product add(Product product) {
		product.setCategory(categoryService.findById(product.getCategory().getId()));
		return productDetailDao.save(product);
	}

	@Override
	public Product update(Product product) throws Exception {

		int id = product.getId();

				Optional<Product> findById = productDetailDao.findById(id);

				if(findById.isPresent()) {
					Product existingProduct = findById.get();
					
					existingProduct.setProductName(product.getProductName());
					existingProduct.setQuantity(product.getQuantity());
					
					int catId = product.getCategory().getId();
					Optional<Category> category = categoryDao.findById(catId);
					
					if(category.isPresent()) {
						Category existingCategory = category.get();
						existingProduct.setCategory(existingCategory);
					}
						
					
                 return productDetailDao.save(existingProduct);
                 
				}else {
					throw new Exception("This Category is not found in our system.");
				}
				
//		tId().equals(id)) {
//			    	if (p.geroduct.set(i, product);
//			}
//		   }		
//		
//			return productDetailDao.save(product,id);
            
            //return productDetailDao.save(product);
                 
	}

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
		// TODO Auto-generated method stub
		return productDetailDao.findByProductName(prodName);
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

	

}
