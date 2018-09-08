package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.repository.CrudRepository;

import com.nouhoun.springboot.jwt.integration.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
