package com.cos.blog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.domain.Production;
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
	public ResponseEntity<?> register(@RequestBody Production dto) {
		
		System.out.println("production 값 : " +dto);
		productionService.데이터입력하기(dto);
		
		return new ResponseEntity<>(dto ,HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/select/{month}")
	public List<Production> select(@PathVariable String month) {
		
		return productionService.데이터가져오기(month);
	}
	
	@CrossOrigin
	@GetMapping("/selectDate/{day}")
	public Production getDay(@PathVariable String day) {
		return productionService.선택한날짜데이터가져오기(day);
	}
	
	@CrossOrigin
	@GetMapping("/target/{value}")
	public List<Production> target(@PathVariable int value){
		
		return productionService.입력한목표치리스트(value);
	}
	
	@CrossOrigin
	@PutMapping("/updateData/{id}")
	public ResponseEntity<?> update(@PathVariable int id , @RequestBody Production product){
		
		productionService.선택할날짜데이터수정하기(id, product);
		
		return new ResponseEntity<Integer>(1,HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteData/{id}")
	public String delete(@PathVariable int id) {
		
		productionService.선택한날짜데이터삭제하기(id);
		
		return "삭제완료";
	}
}
