package order_managment_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import order_managment_system.entity.Order;
import order_managment_system.entity.Product;
import order_managment_system.entity.User;

@Service
public interface IOrderService {
	
	
	
	public Order addOrder(Order order);


	Order updateOrder(Order order);


	Order deleteOrder(Order order);


	Order getById(int id);


	List<Order> getAllOrder();


	//List<Order> addOrder(List<Order> order, Order order2);


	
	
}
