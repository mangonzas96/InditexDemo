package com.inditex.prices.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "prices")
@Entity
@Data
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer priceId;

	@Column(name = "brand_id")
    private Integer brandId;
    
    @Column(name = "product_id")
    private Integer productId;
    
    @Column(name = "start_date")
    private Date startDate;
    
    @Column(name = "end_date")
    private Date endDate;
    
    @Column(name = "price") 
    private Double price;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "priority")
    private Integer priority;
}
