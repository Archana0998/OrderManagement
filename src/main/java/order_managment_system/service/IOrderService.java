package order_managment_system.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import orderDTO.OrderDTO;
import order_managment_system.entity.Order;
import order_managment_system.entity.Product;
import order_managment_system.entity.User;


public interface IOrderService {
	

	
	public Order addOrder(Order order);

	public OrderDTO addProductInOrder(String product, OrderDTO orderDTO, String paymentMode);
	
	Order updateOrder(Order order);

	Order deleteOrder(Order order);

	List<Order> getAllOrder();

	Order getById(Integer id);

	List<Map<String, Object>> getSoldProducts() throws Exception;

	List<Order> addOrder(List<OrderDTO> orderDTO, Order order);


	//List<Order> addOrder(List<Order> order, Order order2);


	
	
}
