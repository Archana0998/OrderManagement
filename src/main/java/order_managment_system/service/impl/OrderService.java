package order_managment_system.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orderDTO.OrderDTO;
import order_managment_system.dao.IOrderDao;
import order_managment_system.entity.Order;
import order_managment_system.entity.Product;
import order_managment_system.entity.User;
import order_managment_system.service.IOrderService;
import order_managment_system.service.IProductDetailService;

@Service
@Transactional
public class OrderService implements IOrderService {
	
	@Autowired
	private IOrderDao orderDao;
	
	@Autowired
	private IProductDetailService productservice;


	@Override
	public List<Order> getAllOrder() {
		return (List<Order>) orderDao.findAll();
			}
	
	
	public <S> List<Order> addOrder(List<OrderDTO> orderDTO, Order order){
		
		List<Order> orderResponse =new ArrayList<Order>();
		
		try {
			Random rand = new Random();
			int id = rand.nextInt(1000);
			for (OrderDTO o : orderDTO) {
			Product product = productservice.getById(o.getId());
			if(product == null) {
			throw new Exception("Product Not Found");
		} 
			product.setQuantity(product.getQuantity() - o.getQuantity());
			if (product.getQuantity() == 0 ) {
				product.setStatus(false);// product not available
			} else {
				product.setStatus(true);// product available
			}
						
			o.setOrdId(id);
			productservice.save(product);
			//orderResponse.add(orderDao.save(dtoToEntity(o, product, order)));
			}
		}
			catch (Exception e) {
			// TODO: handle exception
		}
			
			
		
		
		
	}
	
	
	
	
	
	
	
	
	
	private Object dtoToEntity(OrderDTO o, Product product, Order order) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Order addOrder(Order order) {
		System.out.println("service ...");
		return (Order) orderDao.save(order);
	}

	@Override
	public Order deleteOrder(Order order) {
		System.out.println("service ...");
		return (Order) orderDao.save(order);
	}
	
	@Override
	public Order updateOrder(Order order) {
		System.out.println("service ...");
		return (Order) orderDao.save(order);
	}

	@Override
	public Order getById(int id) {
		return orderDao.findById(id).get();
	}

	

}