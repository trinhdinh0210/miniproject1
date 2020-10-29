package com.twendee.scrud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.twendee.scrud.entity.User;
import com.twendee.scrud.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index(Model model) {

		return "redirect:/1/10";
	}

	@GetMapping("/{pageNo}/{pageSize}")
	public String getPaginatedUser(@PathVariable int pageNo, @PathVariable int pageSize, Model model) {
		Page<User> users = userService.findAll(PageRequest.of(pageNo - 1, pageSize));

		model.addAttribute("users", users);

		return "index";
	}

//	@RequestMapping("/")
//	public String index(Model model) {
//		List<User> users = userService.getAllUser();
//
//		model.addAttribute("users", users);
//
//		return "index";
//	}

	@RequestMapping(value = "add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam("id") String userId, Model model) {
		Optional<User> userEdit = userService.findUserById(userId);
		userEdit.ifPresent(user -> model.addAttribute("user", user));
		return "editUser";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(User user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") String userId, Model model) {
		userService.deleteUser(userId);
		return "redirect:/";

	}

	@GetMapping("/search")
	public String search(@RequestParam("p") String p, Model model) {
		if (StringUtils.isEmpty(p)) {
			return "redirect:/";
		}
		model.addAttribute("contacts", userService.search(p));
        return "index";

	}
}