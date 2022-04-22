package order_managment_system.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "catname")
	private String catName;
	
	private int count;
	
	
	@OneToMany(mappedBy="category", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Product> products;

	public int getId() {
		return Id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Category(int id, String catName) {
		super();

		Id = id;
		this.catName = catName;
	}

	public Category() {
		
	}
	
	@Override
	public String toString() {
		return "Category [Id=" + Id + ", catName=" + catName + "]";
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
