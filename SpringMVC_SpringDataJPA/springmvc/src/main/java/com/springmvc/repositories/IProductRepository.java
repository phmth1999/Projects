package com.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity, Integer>{

}
