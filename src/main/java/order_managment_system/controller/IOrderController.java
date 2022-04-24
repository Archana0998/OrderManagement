package order_managment_system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import order_managment_system.entity.Order;

@RequestMapping("/order")
public interface IOrderController {

	@GetMapping("/getById")
	public Order getById(int id);

	@PostMapping("/add")
	public Order addOrder(Order order);

	@GetMapping("/getAll")
	List<Order> getAllOrder();

}
