package com.inditex.prices.service;

import com.inditex.prices.dto.request.PriceByBrandProductDateRequestDTO;
import com.inditex.prices.entity.Price;

public interface PriceService {
	
	Price getPrice(PriceByBrandProductDateRequestDTO priceRequestDto);

}
