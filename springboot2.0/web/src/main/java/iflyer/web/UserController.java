package iflyer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import iflyer.model.User;
import iflyer.service.UserService;

/**
 * Created by liuxin on 17/1/20.
 */
@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("{id}/user")
	public User getUserInfo(@PathVariable(name = "id") Integer id) {
		User user = userService.getUser(id);
		return user;
	}

	@GetMapping("/save/{name}/{age}")
	public Integer saveUserInfo(@PathVariable(name = "name") String name, @PathVariable(name = "age") Integer age) {
		int user = userService.saveUser(name, age);
		return user;
	}

}