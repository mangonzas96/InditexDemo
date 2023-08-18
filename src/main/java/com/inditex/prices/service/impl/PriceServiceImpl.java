package com.inditex.prices.service.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.prices.daos.PriceRepository;
import com.inditex.prices.dto.request.PriceByBrandProductDateRequestDTO;
import com.inditex.prices.entity.Price;
import com.inditex.prices.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
    private PriceRepository priceRepository;

	@Override
	public Price getPrice(PriceByBrandProductDateRequestDTO priceRequestDto) {
		return findPricesByBrandProductDate(priceRequestDto).stream().
				max(Comparator.comparing(Price::getPriority)).
				orElseThrow(NoSuchElementException::new);
	}
	
	@Override
	public Collection<Price> getMultiPrice(PriceByBrandProductDateRequestDTO priceRequestDto) {
		return findPricesByBrandProductDate(priceRequestDto);
	}
	
	private Collection<Price> findPricesByBrandProductDate(PriceByBrandProductDateRequestDTO priceRequestDto) {
		return priceRepository.findByBrandAndProductAndDate(priceRequestDto.getBrandId(), 
				priceRequestDto.getProductId(), priceRequestDto.getApplicationDate());
	}
    
}
