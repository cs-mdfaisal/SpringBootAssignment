package com.phoenix.controllers;
/*
 * Request processor web component of spring web MVC
 */

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phoenix.entities.User;
import com.phoenix.exceptions.UserNotFoundException;
import com.phoenix.services.UserService;
import com.phoenix.services.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	//@RequestMapping(path="/login",method=RequestMethod.POST)
	@PostMapping("/login")
	public String validateUser(User user,ModelMap map,HttpSession session) {
		
	try {
		User dbUser = userService.findByUsername(user.getUsername());
	
		if(dbUser.getPassword().equals(user.getPassword()))
		{
			
		map.addAttribute("uname", user.getUsername());
			
			return "welcome.jsp";
		}
		else {
			map.addAttribute("logonerror", "Invalid username/password");
			session.setAttribute("logonerror","Invalid username/password");
			return "redirect:/login-error";
			//return "redirect:/login.jsp";
		}

	} catch (UserNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		map.addAttribute("logonerror",e.getMessage());
		return "login.jsp";
	}
		}
	//@RequestMapping(path = "/login-error",method = RequestMethod.GET)
	@GetMapping("/login-error")
	public String loginError() {
		return "login.jsp";
	}
}
