package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.admin.AdminUpdateDTO;
import com.green.nowon.domain.entity.GoodsEntityRepository;
import com.green.nowon.service.AdminService;

@Service
public class AdminServiceProcess implements AdminService {

	@Autowired
	private GoodsEntityRepository repo;
	
	@Override
	public void update(long gno, AdminUpdateDTO dto) {
		repo.findById(gno).map(entity->entity.update(dto));
	}

}
