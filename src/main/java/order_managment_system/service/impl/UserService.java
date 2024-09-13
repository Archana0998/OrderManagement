 	package order_managment_system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import order_managment_system.dao.IUserDao;
//import com.myproject.Dao.IUserDao;
import order_managment_system.entity.User;
import order_managment_system.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDao userDao; 
	
	@Override
	public User add(User admin) {
		return userDao.save(admin); 
		
	}

	@Override
	public User getAdminById(int id) {
		return userDao.findById(id).get();
	}

	@Override
	public User update(User admin) {
		// TODO Auto-generated method stub
		return userDao.save(admin);
		
//		
//		 @Override User loadUserByUsername(String username) 
//		         throws UsernameNotFoundException {
//
//		        User user = adminDao.findByEmail(username);
//		        if (user == null) {
//		            throw new UsernameNotFoundException
//		                ("Invalid username or password.");
//		        }
//		        return new org.springframework.security.core.userdetails.
//		                User(user.getEmail(), user.getPassword(),
//		                mapRolesToAuthorities(user.getRoles()));
//		 }
		 
	
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loginUser(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
		
	}
	
	
	
	
}

