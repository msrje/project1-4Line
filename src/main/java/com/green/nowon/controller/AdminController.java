package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/admin/goods/{gno}")
	public String adminDetail(@PathVariable long gno, Model model) {
		service.adminDetail(gno, model);
		return "admin/admin-detail";
	}
}
