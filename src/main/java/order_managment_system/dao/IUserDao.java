package order_managment_system.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import order_managment_system.entity.User;

@Qualifier
@Repository
public interface IUserDao extends CrudRepository<User, Integer>  {
	
	
//	@Query("Select u from User u where id= :id AND password= :pass")
	
	
	
	public User findByEmailAndPassword(String email, String password);
	
	
	
	
}
