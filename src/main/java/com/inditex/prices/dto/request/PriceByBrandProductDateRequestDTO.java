package com.inditex.prices.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceByBrandProductDateRequestDTO {

	@JsonProperty("brand_id")
    private int brandId;
    
	@JsonProperty("product_id")
    private int productId;
    
	@JsonProperty("application_date")
    private Date applicationDate;
}
