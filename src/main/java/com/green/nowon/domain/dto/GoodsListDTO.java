package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class GoodsListDTO {
	
	private long gno;
	private String title;
	private int price;
	private int stock;
	private LocalDateTime updatedDate;
	
}