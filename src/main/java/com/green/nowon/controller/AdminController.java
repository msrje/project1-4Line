package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public String admin() {
		return "admin/default";
	}
	
	@GetMapping("/admin/goods/list")
	public String list() {
		return "admin/admin-list";
	}
}
