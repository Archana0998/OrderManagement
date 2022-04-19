package order_managment_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import order_managment_system.entity.User;


@Service
public interface IUserService {

	public User getAdminById(int id);

	
	public User update(User user);

	public User add(User user);

    public List<User> getAll();
    
   
    
    

	public User loginUser(String email, String password);


}
