package com.inditex.prices.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PriceDTO {

	@JsonProperty("price_id")
	private Integer priceId;
    
	@JsonProperty("product")
    private ProductDTO product;
    
	@JsonProperty("start_date")
    private Date startDate;
    
	@JsonProperty("end_date")
    private Date endDate;
    
	@JsonProperty("price")
    private Double cost;
    
	@JsonProperty("currency")
    private String currency;

	@JsonProperty("priority")
	private Integer priority;

}
