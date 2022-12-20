package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
		return "redirect:/admin/goods/list";
	}
	

	@GetMapping("/comm/goods/list")
	public String userGoodsList(Model model) {
		gService.findAll(model);
		return "goods/user-list";
	}

	//1차 카테고리 불러오기
	@GetMapping("/common/categorys")
	public String categoryList(Model model) {
		gService.categoryList(model);
		return "goods/category";
	}
	
	//서브(2차) 카테고리
	@GetMapping("/common/categorys/{cno}")
	public String categoryList(@PathVariable long cno, Model model) {
		gService.categoryList(cno, model);
		return "goods/category";
	}
	

	//장바구니
	@GetMapping("/cart")
	public String cart() {
		return "goods/cart";
	}

	
}
