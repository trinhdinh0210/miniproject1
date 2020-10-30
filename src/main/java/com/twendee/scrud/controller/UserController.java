package com.twendee.scrud.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
//
//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public String editUser(@RequestParam("id") String userId, Model model) {
//		Optional<User> userEdit = userService.findUserById(userId);
//		userEdit.ifPresent(user -> model.addAttribute("user", user));
//		return "editUser";
//	}
	 @GetMapping(value = "/edit")
	    public String editUser(@RequestParam("id") String userId, Model model) {
	        Optional<User> userEdit = userService.findUserById(userId);
	        if (userEdit.isPresent()) {
	            model.addAttribute("user", userEdit.get());
	            if (userEdit.get().getAvatar() != null) {
	                model.addAttribute("image",
	                        Base64.getEncoder().encodeToString(userEdit.get().getAvatar().getData()));
	            }
	        }
	        return "editUser";
	    }

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("image") MultipartFile image, User user) {
		try {
			user.setAvatar(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userService.saveUser(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") String userId, Model model) {
		userService.deleteUser(userId);
		return "redirect:/";

	}
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile(@RequestParam("id") String userId,Model model) {
		Optional<User> userProfile = userService.findUserById(userId);
		
		if (userProfile.isPresent()) {
            model.addAttribute("user", userProfile.get());
            if (userProfile.get().getAvatar() != null) {
                model.addAttribute("image",
                        Base64.getEncoder().encodeToString(userProfile.get().getAvatar().getData()));
            }
        }
		
		
		return "profile";
	}

	 @RequestMapping("search")
	    public String search(@RequestParam(defaultValue = "1") int pageNo,
	                         @RequestParam(defaultValue = "10") int pageSize, @RequestParam(value = "q", required = false) String q, Model model) {

	        Page<User> searchUsers = userService.findUserByName(PageRequest.of(pageNo - 1, pageSize), q);
	        model.addAttribute("users", searchUsers);
	        model.addAttribute("query", q);

	        return "search";
	    }
}