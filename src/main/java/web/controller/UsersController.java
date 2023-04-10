package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public String showUserList(Model model) {
		model.addAttribute("UserList", userService.getAllUsers());
		return "list";
	}

	@GetMapping(value = "/new")
	public String showNewUser(ModelMap model) {
		User user = new User();
		model.addAttribute("addnew", true);
		model.addAttribute("user", user);
		return "info";
	}

	@PostMapping(value = "/new")
	public String addNewUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	@GetMapping("/{id}")
	public String showEditUser(@PathVariable("id") int id, ModelMap model) {
		User user = userService.getUserById(id);
		model.addAttribute("addnew", false);
		model.addAttribute("user", user);
		return "info";
	}

	@PutMapping("/{id}")
	public String editUser(@ModelAttribute("user") User user) {
		userService.updateUser(user);
		return "redirect:/";
	}

	@DeleteMapping  ("/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.removeUserById(id);
		return "redirect:/";
	}


	
}