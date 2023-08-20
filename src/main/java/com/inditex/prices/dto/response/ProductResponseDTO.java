package com.inditex.prices.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductResponseDTO {

	@JsonProperty("product_reference")
	private Integer productReference;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("description")
    private String description;	
}
