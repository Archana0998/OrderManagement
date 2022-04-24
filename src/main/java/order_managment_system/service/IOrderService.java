package order_managment_system.service;

import java.util.List;
import order_managment_system.entity.Order;
public interface IOrderService {
	

	
	public Order addOrder(Order order);

		
	Order updateOrder(Order order);

	Order deleteOrder(Order order);

	List<Order> getAllOrder();

	Order getById(Integer id);


	//List<Order> addOrder(List<Order> order, Order order2);


	
	
}
