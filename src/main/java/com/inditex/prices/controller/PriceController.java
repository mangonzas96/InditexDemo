package com.inditex.prices.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.prices.dto.request.PriceByBrandProductDateRequestDTO;
import com.inditex.prices.dto.response.MultiPriceResponseDTO;
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
	
	@PostMapping(value = "/getMultiPrice")
    @ResponseBody
    public List<MultiPriceResponseDTO> getMultiPrices(@RequestBody PriceByBrandProductDateRequestDTO priceRequestDto) {
		
		return priceService.getMultiPrice(priceRequestDto).stream()
		          .map(this::convertToMultiPriceResponseDto)
		          .collect(Collectors.toList());
    }
	
	private PriceResponseDTO convertToPriceResponseDto(Price price) {
		return modelMapper.map(price, PriceResponseDTO.class);
	}
	
	private MultiPriceResponseDTO convertToMultiPriceResponseDto(Price price) {
		return modelMapper.map(price, MultiPriceResponseDTO.class);
	}
}
