package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.member.MemberInsertDTO;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.security.MyRole;
import com.green.nowon.service.MemberService;

@Service
public class MemberServiceProcess implements MemberService {

	@Autowired
	private MemberEntityRepository Mrepo;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Override
	public void save(MemberInsertDTO dto) {
		Mrepo.save(dto.entity(pe).addRole(MyRole.USER));
	}

}
