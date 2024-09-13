package order_managment_system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import order_managment_system.dao.IOrderDao;
import order_managment_system.dao.IUserDao;
import order_managment_system.entity.Order;
import order_managment_system.entity.Product;
import order_managment_system.entity.User;
import order_managment_system.service.IOrderService;
import order_managment_system.service.IProductDetailService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderDao orderDao;

	@Autowired
	private IProductDetailService productservice;

	@Autowired
	private IUserDao userDao;

	@Override
	public List<Order> getAllOrder() {
		return (List<Order>) orderDao.findAll();

	}

	@Override
	public Order addOrder(Order order) throws Exception {
        
		try {
			System.out.println("new order  : " + order);
			Product existingProduct = productservice.getById(order.getProduct().getId());
			System.out.println("product : " + existingProduct);

			if (existingProduct == null) {
				throw new Exception("Product Not Found");
			}

			if (existingProduct.getQuantity() < order.getQuantity()) {
				
				throw new Exception("product Quentity is grater then you inter");
			} else {
				existingProduct.setQuantity(existingProduct.getQuantity() - order.getQuantity());

				if (existingProduct.getQuantity() == 0) {
					existingProduct.setStatus("Not Available");// product not available
				} else {
					existingProduct.setStatus("Available");// product available
				}
				
				System.out.println("FINAL PRODUCT : "+ existingProduct);
				productservice.save(existingProduct);

				Optional<User> findById = userDao.findById(1);
				
				if(findById.isPresent()) {
					order.setUser(findById.get());
					
					System.out.println("USER FOUND : "+findById.get());
					
				}

				order.setProduct(existingProduct);

				order.setTotalPrice(order.getQuantity() * existingProduct.getPrice());

				System.out.println("FINAL ORDER : "+order );
				orderDao.save(order);
			}
		} catch (Exception e) {
			System.out.println(e);

		}
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
	public Order getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}