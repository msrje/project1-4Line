package com.green.nowon.domain.dto.goods;

import com.green.nowon.domain.entity.GoodsEntity;

import lombok.Setter;

@Setter
public class GoodsInsertDTO {
	
	private long gno;
	private String title;
	private String content;
	private int price;
	private int stock;
	
	public GoodsEntity entity() {
		return GoodsEntity.builder()
				.gno(gno)
				.title(title)
				.content(content)
				.price(price)
				.stock(stock)
			.build();
	}
	
}
