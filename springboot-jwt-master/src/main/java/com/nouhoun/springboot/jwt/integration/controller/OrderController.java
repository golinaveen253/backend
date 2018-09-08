package com.nouhoun.springboot.jwt.integration.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.bean.OrderBean;
import com.nouhoun.springboot.jwt.integration.domain.Order;
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
	
	@PostMapping(value="/save")
    public ResponseEntity<String> saveOrder(@RequestBody OrderBean order) throws ParseException{
		Order table = new Order();
		table.setAmountCollected(order.getAmount_collected());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		table.setDeliveryDate(sdf.parse(order.getDelivery_date()));
		table.setMobile(order.getMobile());
		table.setName(order.getName());
		table.setNoOfCards(order.getNo_of_cards());
		table.setTime(order.getTime());
		table.setTotalAmount(order.getTotal_amount());
		table.setWork(order.getWork());
		Order ord = orderService.saveOrder(table);
		return new ResponseEntity<String>("Response from POST method", HttpStatus.OK);
		
    }
	
}
