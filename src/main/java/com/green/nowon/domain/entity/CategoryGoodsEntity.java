package com.green.nowon.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "category_goods")
@Entity
public class CategoryGoodsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cgno;
	
	@JoinColumn
	@ManyToOne
	private CategoryEntity category;
	
	@JoinColumn
	@ManyToOne
	private GoodsEntity goods;

}