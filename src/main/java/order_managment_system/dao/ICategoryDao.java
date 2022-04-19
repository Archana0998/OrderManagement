package order_managment_system.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import order_managment_system.entity.Category;

@Qualifier
@Repository
public interface ICategoryDao extends CrudRepository<Category,Integer> {

	
}
