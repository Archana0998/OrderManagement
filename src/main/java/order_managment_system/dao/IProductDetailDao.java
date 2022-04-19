package order_managment_system.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import order_managment_system.entity.Category;
import order_managment_system.entity.Product;

@Qualifier
@Repository
public interface IProductDetailDao extends CrudRepository<Product, Integer> {


	
	public Product findByProductName(String prodName);

	
	
//	public Product save(Product product, int id);

	

}
