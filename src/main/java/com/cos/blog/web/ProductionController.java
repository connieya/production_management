package com.cos.blog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.domain.Production;
import com.cos.blog.dto.ProductionDto;
import com.cos.blog.service.ProductionService;

@RestController
public class ProductionController {
	
	@Autowired
	ProductionService productionService;
	
	@GetMapping("/")
	public String index() {
		return "ㅎㅎ";
	}

	@CrossOrigin
	@PostMapping("/insert")
	public String register(@RequestBody Production dto) {
		
		System.out.println("production 값 : " +dto);
		productionService.데이터입력하기(dto);
		
		return "값 입력 완료";
	}
	
	@CrossOrigin
	@GetMapping("/select/{month}")
	public List<Production> select(@PathVariable String month) {
		
		return productionService.데이터가져오기(month);
	}
	
	@GetMapping("/target/{value}")
	public List<Production> target(@PathVariable int value){
		
		return productionService.입력한목표치리스트(value);
	}
}
