package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import com.green.nowon.domain.entity.Goods;


import lombok.Getter;


@Getter
public class GoodsDetailDTO {
	
	private long gno;
	private String title;
	private int price;
	private int stock;
	private String content;
	private LocalDateTime updatedDate;
	private LocalDateTime createdDate;
	
	public GoodsDetailDTO(Goods e) {
		this.gno =e.getGno();
		this.title = e.getTitle();
		this.content = e.getContent();
		this.price = e.getPrice();
		this.stock = e.getStock();
		this.createdDate=e.getCreatedDate();
		this.updatedDate=e.getUpdatedDate();
		
	}
	
	
		

}
