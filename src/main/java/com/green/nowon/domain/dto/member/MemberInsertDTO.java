package com.green.nowon.domain.dto.member;

import lombok.Setter;

@Setter
public class MemberInsertDTO {
	
	private String email;
	private String pass;
	private String nickName;
	
	public MemberInsertDTO() {
		
	}
}
