package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.nowon.service.GoodsService;

@Controller
public class AdminController {
	
	@Autowired
	private GoodsService service;
	
	@GetMapping("/admin")
	public String admin() {
		return "admin/default";
	}
	
	@GetMapping("/admin/goods/list")
	public String list(Model model) {
		service.findAll(model);
		return "admin/admin-list";
	}
}
