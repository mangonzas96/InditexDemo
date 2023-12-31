package com.inditex.prices.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "prices")
@Entity
@Data
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer priceId;
    
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_ref", referencedColumnName = "product_ref")
    private Product product;
    
    @Column(name = "start_date")
    private Date startDate;
    
    @Column(name = "end_date")
    private Date endDate;
    
    @Column(name = "price") 
    private Double cost;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "priority")
    private Integer priority;
}
