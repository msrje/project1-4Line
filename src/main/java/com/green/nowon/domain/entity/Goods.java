package com.green.nowon.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "gen_seq_good",
		sequenceName = "seq_good", initialValue = 1, allocationSize = 1)
@Table(name = "goods")
@Entity
public class Goods extends BaseDateEntity{
	
	@Id
	@GeneratedValue(generator = "gen_seq_good", strategy = GenerationType.SEQUENCE)
	private long gno;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false, columnDefinition = "text")
	private String content;
	private int price;
	private int stock;


}