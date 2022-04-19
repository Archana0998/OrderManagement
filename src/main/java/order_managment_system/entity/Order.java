package order_managment_system.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private String paymentmode;
	
	private int quantity;
	
	
   @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id_fk")
	private User user;
	
	public String getPaymentmode() {
		return getPaymentmode();
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

		
	@Override
	public String toString() {
		return "Order [paymentmode=" + paymentmode + "]";
	}
	

}
