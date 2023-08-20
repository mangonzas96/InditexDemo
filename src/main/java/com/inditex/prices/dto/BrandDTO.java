package com.inditex.prices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BrandDTO {

	@JsonProperty("brand_id")
	private Integer brandId;
	
	@JsonProperty("brand_ref")
	private Integer brandReference;
	
	@JsonProperty("name")
    private String name;
	
}