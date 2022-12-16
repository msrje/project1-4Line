package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.green.nowon.domain.dto.admin.AdminUpdateDTO;
import com.green.nowon.service.AdminService;
import com.green.nowon.service.impl.AdminServiceProcess;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminController {
	
	@Autowired
	private AdminService aService;
	
	@GetMapping("/admin")
	public String admin() {
		return "admin/default";
	}
	
	@GetMapping("/admin/goods/list")
	public String list() {
		return "admin/admin-list";
	}
	
	
	@PatchMapping("/admin/goods/{gno}")
	public String update(@PathVariable long gno ,AdminUpdateDTO dto) {
		aService.update(gno, dto);
		return "redirect:/admin/goods/list";
	}
}
