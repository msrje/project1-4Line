package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.admin.AdminUpdateDTO;

public interface AdminService {

	void update(long gno, AdminUpdateDTO dto);


}
