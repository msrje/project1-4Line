package com.green.nowon.domain.dto.goods;

import com.green.nowon.domain.entity.Goods;

import lombok.Setter;

@Setter
public class GoodsInsertDTO {
	
	private long gno;
	private String title;
	private String content;
	private int price;
	private int stock;
	
	public Goods entity() {
		return Goods.builder()
				.gno(gno)
				.title(title)
				.content(content)
				.price(price)
				.stock(stock)
			.build();
	}
	
}
