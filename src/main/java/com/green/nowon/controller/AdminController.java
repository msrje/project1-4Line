package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.green.nowon.service.GoodsService;


import com.green.nowon.domain.dto.admin.AdminUpdateDTO;
import com.green.nowon.service.AdminService;
import com.green.nowon.service.impl.AdminServiceProcess;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminController {
	
	@Autowired
	private AdminService aService;
	
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
	
	@PatchMapping("/admin/goods/{gno}")
	public String update(@PathVariable long gno ,AdminUpdateDTO dto) {
		System.out.println("update patch 작동");
		aService.update(gno, dto);
		return "redirect:/admin/goods/list";
	}
	
	@GetMapping("/admin/goods/{gno}")
	public String adminDetail(@PathVariable long gno, Model model) {
		service.adminDetail(gno, model);
		return "admin/admin-detail";

	}
}
