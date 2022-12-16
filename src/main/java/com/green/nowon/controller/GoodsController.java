package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.nowon.domain.dto.goods.GoodsInsertDTO;
import com.green.nowon.service.GoodsService;

@Controller
public class GoodsController {
	
	@Autowired
	GoodsService gService;
	
	@GetMapping("/admin/goods")
	public String goods() {
		return "goods/reg";
	}
	
	@GetMapping("/admin/goods/reg")
	public String goodsInsert(GoodsInsertDTO dto) {
		gService.save(dto);
		return "redirect:/admin";
	}
	
	@GetMapping("/comm/goods/list")
	public String userGoodsList() {
		return "goods/user-list";
	}
	
}
