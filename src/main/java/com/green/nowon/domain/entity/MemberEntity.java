package com.green.nowon.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(name = "seq_gen_member", 
		sequenceName = "seq_member", initialValue = 1, allocationSize = 1)
@Table(name = "member")
@Entity
public class MemberEntity extends BaseDateEntity{
	
	@GeneratedValue(generator = "seq_gen_member", strategy = GenerationType.SEQUENCE)
	@Id
	private long mno;
	
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String pass;
	@Column(unique = true)
	private String nickName;
	
}
