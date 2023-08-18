package com.inditex.prices.service;

import java.util.Collection;

import com.inditex.prices.dto.request.PriceByBrandProductDateRequestDTO;
import com.inditex.prices.entity.Price;

public interface PriceService {
	
	Price getPrice(PriceByBrandProductDateRequestDTO priceRequestDto);
	
	Collection<Price> getMultiPrice(PriceByBrandProductDateRequestDTO priceRequestDto);

}
