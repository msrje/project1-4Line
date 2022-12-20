package com.green.nowon.service;

import com.green.nowon.domain.dto.cart.CartGoodsSaveDTO;

public interface CartService {

	void save(CartGoodsSaveDTO dto, String email);

}
