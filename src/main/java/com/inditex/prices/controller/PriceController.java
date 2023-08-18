package com.inditex.prices.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.prices.dto.PriceDTO;
import com.inditex.prices.dto.request.PriceByDateBrandProductRequestDTO;
import com.inditex.prices.entity.Price;
import com.inditex.prices.service.PriceService;

@RestController
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping(value = "/{id}")
    public PriceDTO priceById(@PathVariable("id") Integer id) {
 
        return convertToDto(priceService.getPriceById(id));
    }
	
	@PostMapping
    @ResponseBody
    public PriceDTO getMultiprices(@RequestBody PriceByDateBrandProductRequestDTO priceByDateBrandProductRequestDto) {
		
        return null;//convertToDto(priceService.getByDateAndBrandAndProduct(priceByDateBrandProductRequestDto));
    }
	
	private PriceDTO convertToDto(Price price) {
		return modelMapper.map(price, PriceDTO.class);
	}
}
