package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/members/signin")
	public String signin() {return "views/sign/signin";}
	
	@GetMapping("/members/signup")
	public String signup() {return "views/sign/signup";}
	
}
