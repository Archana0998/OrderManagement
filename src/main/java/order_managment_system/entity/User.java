package order_managment_system.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

	@Entity
	@Table(name="user")
	
	public class User implements Serializable {
		 
		 @Id
		 @GeneratedValue(strategy=GenerationType.IDENTITY)
		 @Column(name="id")
		 private int id;
		 
		 @Column(name="name")
		 @NotBlank(message ="name not Empty")
		 @Size(min =3,message="Name must above 3 charactor")
		 private String name;
		
		 @Column(name="email")
		 @Email(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9+.-]+$")
		 @NotBlank(message ="name not Empty")
		 private String email;
		 
		@Column(name="phone")
		//@Pattern(regexp="(^\\\\d{10}$)")
		//@NotBlank(message ="name not Empty")
		private long phone;
		 
		 @Column(name="password")
		// @Pattern(regexp = "^[a-zA-Z0-9]{4}", message="Length Must be 4")
		 private String password;
		 
		 @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
		 private Order order;
			
		
		 
		 public User(int id, String name, String email, long phone, String password) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.password = password;
		    }
		 
		 
		 
		 public User(){
			 
		 }
		 
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		@Override
		public String toString() {
			return "Register [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
					+ password + "]";
		}
		 
	
		
	 
}
