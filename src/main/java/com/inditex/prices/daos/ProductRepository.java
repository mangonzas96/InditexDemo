package com.inditex.prices.daos;

import org.springframework.data.repository.CrudRepository;

import com.inditex.prices.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
