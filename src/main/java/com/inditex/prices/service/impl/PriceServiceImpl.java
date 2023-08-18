package com.inditex.prices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.prices.daos.PriceRepository;
import com.inditex.prices.dto.request.PriceByDateBrandProductRequestDTO;
import com.inditex.prices.entity.Price;
import com.inditex.prices.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
    private PriceRepository priceRepository;
	
	@Override
	public Price getPriceById(Integer id) {
		return priceRepository.findById(id).get();
	}
	
	@Override
	public List<Price> getByDateAndBrandAndProduct(PriceByDateBrandProductRequestDTO priceByDateBrandProductRequestDto) {
		return priceRepository.findByBrandAndProductAndDate(priceByDateBrandProductRequestDto., null, null);
	}
    
}
