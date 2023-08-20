package com.inditex.prices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "brands")
@Entity
@Data
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer brandId;

	@Column(name = "brand_ref")
    private Integer brandReference;
	
	@Column(name = "name")
    private String name;
	
}
