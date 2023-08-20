package com.inditex.prices.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BrandResponseDTO {

	@JsonProperty("brand_ref")
	private Integer brandReference;
	
	@JsonProperty("name")
    private String name;
}
