package order_managment_system.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import order_managment_system.controller.IUserController;
import order_managment_system.entity.User;
import order_managment_system.service.IUserService;


@CrossOrigin
@RestController
public class UserController implements IUserController {

	@Autowired
	private IUserService userService;

	@Override
	public User add(@RequestBody User user) {
	  return userService.add(user);

	}

	public User getAdminById(int id) {
       return userService.getAdminById(id);
	}
	
	

	public User update(User admin) {
		return userService.update(admin);

	}

	@Override
	public User loginUser(String email, String password) {
		return userService.loginUser(email,password);
	}
	
	

	

}
