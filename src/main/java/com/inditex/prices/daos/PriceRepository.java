package com.inditex.prices.daos;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.inditex.prices.entity.Price;

public interface PriceRepository extends CrudRepository<Price, Integer>  {

	@Query(value = "SELECT p FROM Price p " +
			"WHERE p.product.brand.brandReference = :brandRef AND " +
			"p.product.productReference = :productRef AND " +
			"p.startDate <= :applicationDate AND " +
			"p.endDate >= :applicationDate " +
			"ORDER BY p.priority")
	Collection<Price> findByBrandAndProductAndDate(@Param("brandRef") Integer brandRef, 
											 @Param("productRef") Integer productRef, 
											 @Param("applicationDate") Date applicationDate);
}
