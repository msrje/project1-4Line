package com.green.nowon.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.GoodsListDTO;
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
	
	@Override
	public void findAll(Model model) {
		List<GoodsListDTO> result=gRepository.findAll().stream()
				.map(GoodsListDTO::new).collect(Collectors.toList());
		
		model.addAttribute("list", result);
	}
}
