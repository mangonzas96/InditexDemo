package com.inditex.prices.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.prices.dto.request.PriceByBrandProductDateRequestDTO;
import com.inditex.prices.dto.response.BrandResponseDTO;
import com.inditex.prices.dto.response.PriceResponseDTO;
import com.inditex.prices.entity.Price;
import com.inditex.prices.service.PriceService;

@RestController
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@PostMapping(value = "/getPrice")
    @ResponseBody
    public PriceResponseDTO getPrice(@RequestBody PriceByBrandProductDateRequestDTO priceRequestDto) {
		
		return convertToPriceResponseDto(priceService.getPrice(priceRequestDto));
    }
	
	private PriceResponseDTO convertToPriceResponseDto(Price price) {
		
		PriceResponseDTO priceResponse = modelMapper.map(price, PriceResponseDTO.class);
		priceResponse.setBrand(modelMapper.map(price.getProduct().getBrand(), BrandResponseDTO.class));
		return priceResponse;
	}
}
