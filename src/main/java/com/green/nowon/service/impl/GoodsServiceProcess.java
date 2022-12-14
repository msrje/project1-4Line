package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.goods.GoodsInsertDTO;
import com.green.nowon.domain.entity.GoodsEntityRepository;
import com.green.nowon.service.GoodsService;

@Service
public class GoodsServiceProcess implements GoodsService{

	@Autowired
	GoodsEntityRepository gRepository;
	
	
	@Override
	public void save(GoodsInsertDTO dto) {
		gRepository.save(dto.entity());
	}
}
