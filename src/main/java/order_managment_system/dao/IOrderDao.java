package order_managment_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import order_managment_system.entity.Order;
import order_managment_system.entity.Product;


@Qualifier
@Repository
public interface IOrderDao extends CrudRepository<Order, Integer> {

	
//     @Query(value = "select product_name,id, sum(quantity) from  product_details group by category_id_fk")
//	 public List<Object[]> findSoldProducts();
//	
//	 @Query(value = "select sum(quantity) as total from Order")
//     public long findOrderQuantity();


	
}
