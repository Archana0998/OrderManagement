package order_managment_system.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product_details")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "productName")
	private String productName;

	@Column(name = "mfgDate")
	private String mfgDate;

	@Column(name = "expDate")
	private String expDate;

	@Column(name = "price")
	private int price;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "status")
	private Boolean status;

	@ManyToOne()
	@JoinColumn(name = "category_id_fk")
	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

<<<<<<< HEAD
=======
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String productName, String catagory, String mfgDate, String expDate, Integer price,
			Integer quantity, Boolean status, Category category) {
		super();
		this.id = id;
		this.productName = productName;
		this.category = category;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}

>>>>>>> 65b1e927b26025870fd3342e269ca1ed208d6be8
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", mfgDate=" + mfgDate + ", expDate=" + expDate
				+ ", price=" + price + ", quantity=" + quantity + ", status=" + status + ", category=" + category + "]";
	}

}
