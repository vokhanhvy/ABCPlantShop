package com.java.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.model.Customer;
import com.java.repository.CustomerRepository;

@Controller
public class LoginController extends CommonController{

	@Autowired
	CustomerRepository customersRepository;

	@GetMapping(value = "/login")
	public String login(Model model, @RequestParam("error") Optional<String> error) {
		String errorString = error.orElse("false");
		if (errorString.equals("true")) {
			model.addAttribute("error", "Your username or password not correct, please try again!");
		}

		model.addAttribute("customer", new Customer());

		return "site/login";
	}
}
