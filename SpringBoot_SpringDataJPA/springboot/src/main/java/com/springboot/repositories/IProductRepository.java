package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity, Integer>{

}
