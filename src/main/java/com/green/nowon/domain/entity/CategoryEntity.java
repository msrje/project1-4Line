package com.green.nowon.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cno;
	private String cname;
	
	@JoinColumn
	@ManyToOne(fetch = FetchType.LAZY)
	private CategoryEntity parent;
	
	//2차 카테고리
	@Builder.Default
	@OneToMany(mappedBy = "parent")
	List<CategoryEntity> child=new ArrayList<>();
	
	public CategoryEntity addChildCategoryEntity(CategoryEntity cate) {
		child.add(cate);
		return this;
	}
	
	
}
