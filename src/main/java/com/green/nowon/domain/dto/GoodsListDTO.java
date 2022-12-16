package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import com.green.nowon.domain.entity.Goods;

import lombok.Getter;

@Getter
public class GoodsListDTO {
	
	private long gno;
	private String title;
	private int price;
	private int stock;
	private LocalDateTime updatedDate;
	
	public GoodsListDTO(Goods e) {
		this.gno =e.getGno();
		this.title = e.getTitle();
		this.price = e.getPrice();
		this.stock = e.getStock();
		this.updatedDate=e.getUpdatedDate();
		
	}
	
}