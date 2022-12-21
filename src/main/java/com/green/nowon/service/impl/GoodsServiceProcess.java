package com.green.nowon.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.GoodsDetailDTO;
import com.green.nowon.domain.dto.GoodsListDTO;
import com.green.nowon.domain.dto.goods.GoodsInsertDTO;
import com.green.nowon.domain.entity.CategoryRepository;
import com.green.nowon.domain.entity.GoodsEntity;
import com.green.nowon.domain.entity.GoodsEntityRepository;
import com.green.nowon.domain.entity.GoodsImgRepository;
import com.green.nowon.service.GoodsService;

@Service
public class GoodsServiceProcess implements GoodsService{

	@Value("${file.location.temp}")
	private String locationTemp;
	
	@Value("${file.location.upload}")
	private String locationUpload;
	
	
	@Autowired
	GoodsEntityRepository gRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	GoodsImgRepository goodsRepo;
	
	@Override
	public void save(GoodsInsertDTO dto) {
		GoodsEntity entity =gRepository.save(dto.entity());
		dto.toItemListImgs(entity, locationUpload).forEach(goodsRepo::save);
	}

	
	@Override
	public void findAll(Model model) {
		List<GoodsListDTO> result=gRepository.findAll().stream()
				.map(GoodsListDTO::new).collect(Collectors.toList());
		
		model.addAttribute("list", result);
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


	@Override
	public void adminDetail(long gno, Model model) {
		GoodsDetailDTO result=gRepository.findById(gno)
				.map(GoodsDetailDTO::new)
				.orElseThrow();
		model.addAttribute("detail", result);
		
	}


	@Override
	public void Detail(long gno, Model model) {
		GoodsDetailDTO result=gRepository.findById(gno)
				.map(GoodsDetailDTO::new)
				.orElseThrow();
		model.addAttribute("dto", result);
	}


	

}
