package order_managment_system.dao;

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

	
}
