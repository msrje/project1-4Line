package com.green.nowon.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartGoodsEntity {
	//같은 상품을 여러개 주문할수 있으므로 개수표현을 위한 entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	private int count;
	
	@JoinColumn//fk:cart_no
	@ManyToOne
	private CartEntity cart;
	
	@JoinColumn//fk:goods_no
	@ManyToOne
	private Goods item;
	
}
