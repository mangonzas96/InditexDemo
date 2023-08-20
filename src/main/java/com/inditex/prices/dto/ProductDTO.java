package com.inditex.prices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductDTO {

	@JsonProperty("product_id")
	private Integer productId;
	
	@JsonProperty("product_reference")
	private Integer productReference;
	
	@JsonProperty("brand")
    private BrandDTO brand;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("description")
    private String description;	
}
