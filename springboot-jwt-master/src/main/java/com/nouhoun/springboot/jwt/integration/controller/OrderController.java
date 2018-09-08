package com.nouhoun.springboot.jwt.integration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.domain.Work;
import com.nouhoun.springboot.jwt.integration.service.GenericService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private GenericService orderService;
	
	@RequestMapping(value ="/works", method = RequestMethod.GET)
    public List<Work> getTypeOfWorks(){
		return orderService.findAllWorks();
    }
	
}
