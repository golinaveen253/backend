package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.repository.CrudRepository;

import com.nouhoun.springboot.jwt.integration.domain.Work;

public interface WorkRepository extends CrudRepository<Work, Long>{
	
}
