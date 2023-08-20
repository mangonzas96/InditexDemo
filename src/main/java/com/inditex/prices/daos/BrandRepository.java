package com.inditex.prices.daos;

import org.springframework.data.repository.CrudRepository;

import com.inditex.prices.entity.Brand;

public interface BrandRepository extends CrudRepository<Brand, Integer> {

}
