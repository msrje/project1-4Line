package com.green.nowon.domain.dto.admin;

import com.green.nowon.domain.entity.GoodsEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminUpdateDTO {
	
	private String title;
	private String content;
	private int price;
	private int stock;
	
	public GoodsEntity updateEntity() {
		return GoodsEntity.builder()
				.title(title)
				.content(content)
				.price(price)
				.stock(stock)
			.build();
	}
	
}
