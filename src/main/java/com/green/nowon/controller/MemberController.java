package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.member.MemberInsertDTO;
import com.green.nowon.service.MemberService;
import com.green.nowon.service.impl.MemberServiceProcess;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService = new MemberServiceProcess();
	
	@GetMapping("/members/signin")
	public String signin() {return "views/sign/signin";}
	
	@GetMapping("/members/signup")
	public String signup() {return "views/sign/signup";}
	
	@PostMapping("/members/join")
	public String join(MemberInsertDTO dto) {
		mService.save(dto);
		return "/members/signin";
	}
	
}
