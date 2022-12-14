package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.goods.GoodsInsertDTO;
import com.green.nowon.domain.entity.CategoryRepository;
import com.green.nowon.domain.entity.GoodsEntityRepository;
import com.green.nowon.service.GoodsService;

@Service
public class GoodsServiceProcess implements GoodsService{

	@Autowired
	GoodsEntityRepository gRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public void save(GoodsInsertDTO dto) {
		gRepository.save(dto.entity());
	}


	@Override
	public void categoryList(Model model) {
		model.addAttribute("list", 
				categoryRepository.findAllByParentCnoIsNull());
		
	}

	@Override
	public void categoryList(long cno, Model model) {
		model.addAttribute("list", 
				categoryRepository.findAllByParentCno(cno));		
		
	}


	
}
