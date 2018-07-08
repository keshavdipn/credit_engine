package com.tiaa.credit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiaa.credit.domain.CreditCard;
import com.tiaa.credit.service.api.CreditService;

@RestController
public class CreditController {
	
	
	@Autowired
	private CreditService creditService;

	@GetMapping("/CCEngine/{card}/{count}")
	public List<? extends CreditCard> generateCards(@PathVariable("card") String card , @PathVariable("count") int count){
		
		return creditService.generateCards(card, count);
		
	}
}
