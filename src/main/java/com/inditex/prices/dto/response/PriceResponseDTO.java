package com.inditex.prices.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PriceResponseDTO {
	
	@JsonProperty("brand")
    private BrandResponseDTO brand;
    
	@JsonProperty("product")
    private ProductResponseDTO product;
    
	@JsonProperty("start_date")
    private Date startDate;
    
	@JsonProperty("end_date")
    private Date endDate;
    
	@JsonProperty("price")
    private Double cost;
    
	@JsonProperty("currency")
    private String currency;

}
