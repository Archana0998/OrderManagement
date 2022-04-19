package order_managment_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import order_managment_system.entity.User;


@RequestMapping("/User")
public interface IUserController {

	@PostMapping("/add")
	public User add(@RequestBody User user);

	@GetMapping("/getById/{id}")
	public User getAdminById(@PathVariable int id);

	@PutMapping("/update")
	public User update(@RequestBody User user);
	
	@GetMapping("/login")
	public User loginUser(@RequestParam(name = "email") String email,@RequestParam(name = "password")  String password);
	
	
	
}
