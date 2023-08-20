package com.inditex.prices.entity;

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

@Table(name = "products")
@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

	@Column(name = "product_ref")
    private Integer productReference;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "brand_ref", referencedColumnName = "brand_ref")
    private Brand brand;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "description")
    private String description;
    
}
