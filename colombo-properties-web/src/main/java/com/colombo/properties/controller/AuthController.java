package com.colombo.properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.colombo.properties.dto.AuthRequest;
import com.colombo.properties.service.AuthService;

@Controller
public class AuthController {

	@Autowired
	AuthService authService;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginRequest", new AuthRequest());
		mv.setViewName("login");
		return mv;
	}

	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("register");
		return mv;
	}

	@PostMapping("/login")
	public ModelAndView postLogin(@ModelAttribute("loginRequest") AuthRequest request) {

		System.out.println(request);
		ModelAndView mv = new ModelAndView();
		String token = authService.getToken(request);
		authService.Jwt = token;
//		System.out.println("%%%hit");
		System.out.println(token);
		if (authService.Jwt != null)
			mv.setViewName("redirect:/property/create");
		else
			mv.setViewName("redirect:/login");
		return mv;
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/login");
		return mv;
	}
}
