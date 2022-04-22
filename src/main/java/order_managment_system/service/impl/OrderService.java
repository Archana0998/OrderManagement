package order_managment_system.service.impl;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orderDTO.OrderDTO;
import order_managment_system.dao.IOrderDao;
import order_managment_system.dao.IUserDao;
import order_managment_system.entity.Order;
import order_managment_system.entity.Product;
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
	public Order addOrder(Order order) {

		try {
			order.getProduct().getId();
			Product existingProduct = productservice.getById(order.getProduct().getId());

			System.out.println("product : " + existingProduct);

			if (existingProduct == null) {
				throw new Exception("Product Not Found");
			}

			if (existingProduct.getQuantity() < order.getQuantity()) {
				throw new Exception("Order quantity is greather than availability");
			} else {
				existingProduct.setQuantity(existingProduct.getQuantity() - order.getQuantity());
				if (existingProduct.getQuantity() == 0) {
					existingProduct.setStatus(false);// product not available
				} else {
					existingProduct.setStatus(true);// product available
				}
				productservice.save(existingProduct);

				order.setUser(userDao.findById(1).get());

				order.setProduct(existingProduct);

				order.setTotalPrice(order.getQuantity() * existingProduct.getPrice());

				orderDao.save(order);
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return (Order) orderDao.save(order);
	}

	public OrderDTO addProductInOrder(String product, OrderDTO orderDTO, String paymentmode) {

		try {

			JSONObject obj = new JSONObject(product);
			Product pro = productservice.getByName(obj.getString("name"));
			if (pro != null) {
				orderDTO.setId(pro.getId());
				orderDTO.setName(obj.getString("name"));
				orderDTO.setQuantity(obj.getInt("quantity"));

				if (pro.getQuantity() < orderDTO.getQuantity()) {

					throw new Exception("Quantity is more than available quantity");
				} else {
					orderDTO.setPrice(pro.getPrice());
					orderDTO.setTotal(pro.getPrice() * orderDTO.getQuantity());
				}
			} else {
				System.out.println("product not exist");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return orderDTO;
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

	@Override
	public List<Map<String, Object>> getSoldProducts() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> addOrder(List<OrderDTO> orderDTO, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	
}