package order_managment_system.controller.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import order_managment_system.controller.IOrderController;
import order_managment_system.entity.Order;
import order_managment_system.entity.Product;
import order_managment_system.entity.User;
import order_managment_system.service.IOrderService;
import order_managment_system.service.impl.OrderService;

@RestController
public class OrderController implements IOrderController {

	@Autowired
	IOrderService orderService;
	
	@Override
	public Order getById(int id) {
		// TODO Auto-generated method stub
		return orderService.getById(id);
	}

	@Override
	public Order addOrder(@RequestBody Order order) {
		System.out.println("controller ...");
		return orderService.addOrder(order);
	}

	@Override
	public List<Order> getAllOrder() {
		System.out.println("controller ....");
		return orderService.getAllOrder();
	}
}