package com.green.nowon.service;

import com.green.nowon.domain.dto.admin.AdminUpdateDTO;

public interface AdminService {

	void update(long gno, AdminUpdateDTO dto);

	void delete(long gno);


}
