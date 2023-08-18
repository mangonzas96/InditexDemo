package com.inditex.prices.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PriceResponseDTO {
	
	@JsonProperty("brand_id")
    private int brandId;
    
	@JsonProperty("product_id")
    private int productId;
    
	@JsonProperty("start_date")
    private Date startDate;
    
	@JsonProperty("end_date")
    private Date endDate;
    
	@JsonProperty("price")
    private Double price;
    
	@JsonProperty("currency")
    private String currency;

}
