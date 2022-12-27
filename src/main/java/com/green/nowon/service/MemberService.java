package com.green.nowon.service;

import com.green.nowon.domain.dto.member.MemberInsertDTO;
import com.green.nowon.domain.dto.member.MemberCheckDTO;

public interface MemberService {
	void save(MemberInsertDTO dto);
	void check(MemberCheckDTO dto);
}
