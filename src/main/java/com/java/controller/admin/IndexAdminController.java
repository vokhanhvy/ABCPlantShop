package com.java.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexAdminController /* extends CommonController */ {
	@GetMapping("/admin")
	public String index() {		
		return "admin/index";
	}
}
