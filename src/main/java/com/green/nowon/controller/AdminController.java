package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public String admin() {
		return "admin/default";
	}
	
	@GetMapping("/admin/items")
	public String list() {
		return "/admin/상품리스트페이지"; //일단 헷갈릴까봐 한글로 했습니다 !
	}
	
	@GetMapping("/admin/items/reg")
	public String itemsReg() {
		return "/admin/등록페이지";
	}
}
