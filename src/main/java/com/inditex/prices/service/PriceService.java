package com.inditex.prices.service;

import java.util.List;

import com.inditex.prices.dto.request.PriceByDateBrandProductRequestDTO;
import com.inditex.prices.entity.Price;

public interface PriceService {

	Price getPriceById(Integer id);
	
	List<Price> getByDateAndBrandAndProduct(PriceByDateBrandProductRequestDTO priceByDateBrandProductRequestDto);
}
