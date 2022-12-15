package com.green.nowon.domain.dto.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminUpdateDTO {
	
	private String title;
	private String content;
	private int price;
	private int stock;
	
}
